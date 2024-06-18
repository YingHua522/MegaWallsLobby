package fr.minuskube.inv.opener;

import com.google.common.base.Preconditions;
import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class ChestInventoryOpener implements InventoryOpener {
    public ChestInventoryOpener() {
    }

    public Inventory open(SmartInventory inv, Player player) {
        Preconditions.checkArgument(inv.getColumns() == 9, "The column count for the chest inventory must be 9, found: %s.", new Object[]{inv.getColumns()});
        Preconditions.checkArgument(inv.getRows() >= 1 && inv.getRows() <= 6, "The row count for the chest inventory must be between 1 and 6, found: %s", new Object[]{inv.getRows()});
        InventoryManager manager = inv.getManager();
        Inventory handle = Bukkit.createInventory(player, inv.getRows() * inv.getColumns(), inv.getTitle());
        this.fill(handle, (InventoryContents) manager.getContents(player).get());
        player.openInventory(handle);
        return handle;
    }

    public boolean supports(InventoryType type) {
        return type == InventoryType.CHEST || type == InventoryType.ENDER_CHEST;
    }
}
