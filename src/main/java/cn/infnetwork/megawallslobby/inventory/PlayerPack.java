package cn.infnetwork.megawallslobby.inventory;

import cn.infnetwork.megawallslobby.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerPack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                player.sendMessage("§c参数错误");
                return true;
            }
            if (strings[0].equalsIgnoreCase("open")) {
                Inventory inv = Bukkit.createInventory(null, 27, "§6新手礼包");
                player.openInventory(inv);

                ItemBuilder ib = new ItemBuilder(Material.GOLD_BLOCK).setDisplayName("§6新手礼包");
                inv.setItem(13, ib.build());
            }
        }
        return false;
    }
}
