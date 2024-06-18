package fr.minuskube.inv;

import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.opener.ChestInventoryOpener;
import fr.minuskube.inv.opener.InventoryOpener;
import fr.minuskube.inv.opener.SpecialInventoryOpener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class InventoryManager {
    private JavaPlugin plugin;
    private PluginManager pluginManager;
    private Map<Player, SmartInventory> inventories;
    private Map<Player, InventoryContents> contents;
    private List<InventoryOpener> defaultOpeners;
    private List<InventoryOpener> openers;

    public InventoryManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.pluginManager = Bukkit.getPluginManager();
        this.inventories = new HashMap();
        this.contents = new HashMap();
        this.defaultOpeners = Arrays.asList(new ChestInventoryOpener(), new SpecialInventoryOpener());
        this.openers = new ArrayList();
    }

    public void init() {
        this.pluginManager.registerEvents(new InventoryManager.InvListener(), this.plugin);
        (new InventoryManager.InvTask()).runTaskTimer(this.plugin, 1L, 1L);
    }

    public Optional<InventoryOpener> findOpener(InventoryType type) {
        Optional<InventoryOpener> opInv = this.openers.stream().filter((opener) -> {
            return opener.supports(type);
        }).findAny();
        if (!opInv.isPresent()) {
            opInv = this.defaultOpeners.stream().filter((opener) -> {
                return opener.supports(type);
            }).findAny();
        }

        return opInv;
    }

    public void registerOpeners(InventoryOpener... openers) {
        this.openers.addAll(Arrays.asList(openers));
    }

    public List<Player> getOpenedPlayers(SmartInventory inv) {
        List<Player> list = new ArrayList();
        this.inventories.forEach((player, playerInv) -> {
            if (inv.equals(playerInv)) {
                list.add(player);
            }

        });
        return list;
    }

    public Optional<SmartInventory> getInventory(Player p) {
        return Optional.ofNullable(this.inventories.get(p));
    }

    protected void setInventory(Player p, SmartInventory inv) {
        if (inv == null) {
            this.inventories.remove(p);
        } else {
            this.inventories.put(p, inv);
        }

    }

    public Optional<InventoryContents> getContents(Player p) {
        return Optional.ofNullable(this.contents.get(p));
    }

    protected void setContents(Player p, InventoryContents contents) {
        if (contents == null) {
            this.contents.remove(p);
        } else {
            this.contents.put(p, contents);
        }

    }

    class InvTask extends BukkitRunnable {
        InvTask() {
        }

        public void run() {
            inventories.forEach((player, inv) -> {
                inv.getProvider().update(player, (InventoryContents) InventoryManager.this.contents.get(player));
            });
        }
    }

    class InvListener implements Listener {
        InvListener() {
        }

        @EventHandler(
                priority = EventPriority.LOW
        )
        public void onInventoryClick(InventoryClickEvent e) {
            Player p = (Player) e.getWhoClicked();
            if (InventoryManager.this.inventories.containsKey(p)) {
                if (e.getAction() != InventoryAction.COLLECT_TO_CURSOR && e.getAction() != InventoryAction.MOVE_TO_OTHER_INVENTORY && e.getAction() != InventoryAction.NOTHING && e.getAction() != InventoryAction.DROP_ONE_CURSOR && e.getAction() != InventoryAction.DROP_ALL_CURSOR && e.getAction() != InventoryAction.DROP_ONE_SLOT && e.getAction() != InventoryAction.DROP_ALL_SLOT) {
                    if (e.getClickedInventory() == p.getOpenInventory().getTopInventory()) {
                        int row = e.getSlot() / 9;
                        int column = e.getSlot() % 9;
                        if (row < 0 || column < 0) {
                            return;
                        }

                        SmartInventory inv = (SmartInventory) InventoryManager.this.inventories.get(p);
                        if (row >= inv.getRows() || column >= inv.getColumns()) {
                            return;
                        }

                        inv.getListeners().stream().filter((listener) -> {
                            return listener.getType() == InventoryClickEvent.class;
                        }).forEach((listener) -> {
                            listener.accept(e);
                        });
                        if (((InventoryContents) InventoryManager.this.contents.get(p)).get(row, column).isPresent()) {
                            e.setCancelled(((ClickableItem) ((InventoryContents) InventoryManager.this.contents.get(p)).get(row, column).get()).isCancel());
                        }

                        ((InventoryContents) InventoryManager.this.contents.get(p)).get(row, column).ifPresent((item) -> {
                            item.run(e);
                        });
                    }

                } else {
                    e.setCancelled(true);
                }
            }
        }

        @EventHandler(
                priority = EventPriority.LOW
        )
        public void onInventoryDrag(InventoryDragEvent e) {
            Player p = (Player) e.getWhoClicked();
            if (InventoryManager.this.inventories.containsKey(p)) {
                SmartInventory inv = (SmartInventory) InventoryManager.this.inventories.get(p);
                Iterator var4 = e.getRawSlots().iterator();

                while (var4.hasNext()) {
                    int slot = (Integer) var4.next();
                    if (slot < p.getOpenInventory().getTopInventory().getSize()) {
                        e.setCancelled(true);
                        break;
                    }
                }

                inv.getListeners().stream().filter((listener) -> {
                    return listener.getType() == InventoryDragEvent.class;
                }).forEach((listener) -> {
                    listener.accept(e);
                });
            }
        }

        @EventHandler(
                priority = EventPriority.LOW
        )
        public void onInventoryOpen(InventoryOpenEvent e) {
            Player p = (Player) e.getPlayer();
            if (InventoryManager.this.inventories.containsKey(p)) {
                SmartInventory inv = (SmartInventory) InventoryManager.this.inventories.get(p);
                inv.getListeners().stream().filter((listener) -> {
                    return listener.getType() == InventoryOpenEvent.class;
                }).forEach((listener) -> {
                    listener.accept(e);
                });
            }
        }

        @EventHandler(
                priority = EventPriority.LOW
        )
        public void onInventoryClose(InventoryCloseEvent e) {
            Player p = (Player) e.getPlayer();
            if (InventoryManager.this.inventories.containsKey(p)) {
                SmartInventory inv = (SmartInventory) InventoryManager.this.inventories.get(p);
                inv.getListeners().stream().filter((listener) -> {
                    return listener.getType() == InventoryCloseEvent.class;
                }).forEach((listener) -> {
                    listener.accept(e);
                });
                if (inv.isCloseable()) {
                    e.getInventory().clear();
                    InventoryManager.this.inventories.remove(p);
                    InventoryManager.this.contents.remove(p);
                } else {
                    Bukkit.getScheduler().runTask(InventoryManager.this.plugin, () -> {
                        p.openInventory(e.getInventory());
                    });
                }

            }
        }

        @EventHandler(
                priority = EventPriority.LOW
        )
        public void onPlayerQuit(PlayerQuitEvent e) {
            Player p = e.getPlayer();
            if (InventoryManager.this.inventories.containsKey(p)) {
                SmartInventory inv = (SmartInventory) InventoryManager.this.inventories.get(p);
                inv.getListeners().stream().filter((listener) -> {
                    return listener.getType() == PlayerQuitEvent.class;
                }).forEach((listener) -> {
                    listener.accept(e);
                });
                InventoryManager.this.inventories.remove(p);
                InventoryManager.this.contents.remove(p);
            }
        }

        @EventHandler(
                priority = EventPriority.LOW
        )
        public void onPluginDisable(PluginDisableEvent e) {
            inventories.forEach((player, inv) -> {
                inv.getListeners().stream().filter((listener) -> {
                    return listener.getType() == PluginDisableEvent.class;
                }).forEach((listener) -> {
                    listener.accept(e);
                });
                inv.close(player);
            });
            InventoryManager.this.inventories.clear();
            InventoryManager.this.contents.clear();
        }
    }
}
