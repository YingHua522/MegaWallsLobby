package cn.infnetwork.megawallslobby.listener;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.inventory.PlayerPack;
import cn.infnetwork.megawallslobby.task.ScoreBoardTimer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class PlayerListener extends BaseListener {
    public PlayerListener(MegaWallsLobby plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        GamePlayer gamePlayer = GamePlayer.create(player.getUniqueId());
        gamePlayer.getPlayerStats().update();
        Bukkit.getScheduler().runTask(MegaWallsLobby.getInstance(), new ScoreBoardTimer(gamePlayer));
        MegaWallsLobby.getInstance().getHologramManager().createHologram(gamePlayer);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        MegaWallsLobby.getInstance().getHologramManager().removeHologram(GamePlayer.get(e.getPlayer().getUniqueId()));
        GamePlayer.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler(
            priority = EventPriority.LOW
    )
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            if (player.getOpenInventory() != null && player.getOpenInventory().getTopInventory() != null && e.getClickedInventory() != player.getOpenInventory().getTopInventory() && player.getOpenInventory().getTopInventory().getTitle().contains("物品位置") && (e.getAction() == InventoryAction.PLACE_ALL || e.getAction() == InventoryAction.PLACE_ONE || e.getAction() == InventoryAction.PLACE_SOME || e.getAction() == InventoryAction.NOTHING || e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§6新手礼包")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            Player player = (Player) event.getWhoClicked();
            CommandSender consoleSender = Bukkit.getConsoleSender();
            if (event.getSlot() == 13 && event.getCurrentItem().getItemMeta().getDisplayName().equals("§6新手礼包")) {
                if (player.hasPermission("mw.xinren.packs")) {
                    if (event.getClick().isLeftClick()) {
                        player.sendMessage("§c你已经领取过了！");
                        player.closeInventory();
                    }
                } else {
                    if (event.getClick().isLeftClick()) {
                        GamePlayer gp = GamePlayer.get(player.getUniqueId());
                        if (gp != null) {
                            gp.getPlayerStats().giveCoins(100000);
                            gp.getPlayerStats().giveMythicDust(10);
                            Bukkit.dispatchCommand(consoleSender, "lp user " + player.getDisplayName() + " permission set mw.xinren.packs true");
                            player.sendMessage("§a你获取了新手礼包");
                        }
                    }
                }
            }
        }
    }
}
