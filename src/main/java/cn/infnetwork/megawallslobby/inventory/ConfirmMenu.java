package cn.infnetwork.megawallslobby.inventory;

import cn.infnetwork.megawallslobby.util.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.SmartInventory.Builder;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class ConfirmMenu {
    public ConfirmMenu() {
    }

    public static SmartInventory build(String title, final ItemStack itemStack, SmartInventory parentInventory, final Consumer<InventoryClickEvent> consumer) {
        final Builder builder = SmartInventory.builder();
        builder.title(title);
        builder.type(InventoryType.CHEST);
        builder.size(3, 9);
        builder.closeable(true);
        builder.parent(parentInventory);
        builder.provider(new InventoryProvider() {
            public void init(Player player, InventoryContents contents) {
                itemStack.setType(Material.STAINED_CLAY);
                itemStack.setDurability((short) 13);
                contents.set(1, 2, ClickableItem.of(itemStack, consumer));
                contents.set(1, 6, ClickableItem.of((new ItemBuilder(Material.STAINED_CLAY, 1, (byte) 14)).setDisplayName("§c拒绝").setLore(new String[]{"§7返回到上一级菜单。"}).build(), (e) -> {
                    builder.getParent().open(player);
                }));
            }

            public void update(Player player, InventoryContents contents) {
            }
        });
        return builder.build();
    }
}
