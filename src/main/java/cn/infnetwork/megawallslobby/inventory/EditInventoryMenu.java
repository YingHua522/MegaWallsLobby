package cn.infnetwork.megawallslobby.inventory;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import cn.infnetwork.megawallslobby.util.ItemUtils;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EditInventoryMenu {

    public static SmartInventory edit(final Classes classes, SmartInventory parentInventory) {
        final SmartInventory.Builder builder = SmartInventory.builder();
        builder.title("编辑" + classes.getDisplayName() + "的物品位置");
        builder.type(InventoryType.CHEST);
        builder.size(6, 9);
        builder.closeable(true);
        builder.parent(parentInventory);
        builder.provider(new InventoryProvider() {
            public void init(Player player, InventoryContents contents) {
                GamePlayer gamePlayer = GamePlayer.get(player.getUniqueId());
                int slot;
                if (gamePlayer != null && gamePlayer.getPlayerStats().getKitStats(classes).getInventory() == null) {
                    List<ItemStack> items = classes.getEquipmentPackage().getEquipments(gamePlayer.getPlayerStats().getKitStats(classes).getEquipLevel());
                    int[] rows = new int[]{4, 2, 1, 0};
                    int columnx = 0;
                    slot = 0;

                    for (ItemStack item : items) {
                        if (!ItemUtils.isHelmet(item) && !ItemUtils.isChestplate(item) && !ItemUtils.isLeggings(item) && !ItemUtils.isBoots(item)) {
                            contents.set(rows[slot], columnx, ClickableItem.of(item, (e) -> {
                            }, false));
                            ++columnx;
                            if (columnx > 8) {
                                ++slot;
                                columnx = 0;
                            }
                        }
                    }
                }

                contents.fillRow(3, ClickableItem.empty((new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)15)).setDisplayName("§7以下物品都在快捷栏里。").build()));
                contents.set(5, 3, ClickableItem.of((new ItemBuilder(Material.ARROW)).setDisplayName("§a返回").setLore("§7至" + builder.getParent().getTitle()).build(), (e) -> {
                    if (e.getCursor().getType() == Material.AIR) {
                        builder.getParent().open(player);
                    }
                }));
                contents.set(5, 4, ClickableItem.of((new ItemBuilder(Material.CHEST)).setDisplayName("§a保存").build(), (e) -> {
                    if (e.getCursor().getType() == Material.AIR) {
                        EditInventoryMenu.saveInventory(player, classes);
                    }
                }));
                contents.set(5, 5, ClickableItem.of((new ItemBuilder(Material.TNT)).setDisplayName("§c重置物品位置").setLore("§7注意！这将重置物品位置,且无法恢复。").build(), (e) -> {
                    if (e.getCursor().getType() == Material.AIR) {
                        if (gamePlayer != null) {
                            gamePlayer.getPlayerStats().getKitStats(classes).updateInventory(null);
                        }
                        player.closeInventory();
                        player.sendMessage("§a重置成功！");
                    }
                }));
            }

            public void update(Player player, InventoryContents contents) {
            }
        });
        return builder.build();
    }

    private static void saveInventory(Player player, Classes classes) {
        KitStatsContainer kitStats = Objects.requireNonNull(GamePlayer.get(player.getUniqueId())).getPlayerStats().getKitStats(classes);
        Map<Integer, ItemStack> map = new HashMap<>();
        Inventory inventory = player.getOpenInventory().getTopInventory();

        int i;
        ItemStack itemStack;
        for(i = 0; i < 9; ++i) {
            itemStack = inventory.getItem(36 + i);
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                map.put(i, itemStack);
            }
        }

        for(i = 0; i < 9; ++i) {
            itemStack = inventory.getItem(i);
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                map.put(9 + i, itemStack);
            }
        }

        for(i = 0; i < 9; ++i) {
            itemStack = inventory.getItem(9 + i);
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                map.put(18 + i, itemStack);
            }
        }

        for(i = 0; i < 9; ++i) {
            itemStack = inventory.getItem(18 + i);
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                map.put(27 + i, itemStack);
            }
        }

        for (ItemStack stack : map.values()) {
            itemStack = stack;
            if (!contains(itemStack, classes.getEquipmentPackage().getEquipments(kitStats.getEquipLevel()))) {
                player.closeInventory();
                player.sendMessage("§c存在物品不符！保存失败！");
                return;
            }
        }

        JsonObject jsonObject = new JsonObject();

        for (Map.Entry<Integer, ItemStack> integerItemStackEntry : map.entrySet()) {
            jsonObject.addProperty(String.valueOf(integerItemStackEntry.getKey()), Base64.encode(ItemUtils.write(integerItemStackEntry.getValue())));
        }

        kitStats.updateInventory(jsonObject);
        player.sendMessage("§a保存成功！");
        player.closeInventory();
    }

    private static boolean contains(ItemStack itemStack, List<ItemStack> items) {
        int same = 0;

        for (ItemStack item : items) {
            if (item.equals(itemStack)) {
                ++same;
            }
        }

        return same == 1;
    }
}