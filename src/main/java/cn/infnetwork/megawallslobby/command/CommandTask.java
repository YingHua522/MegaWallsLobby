package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.inventory.InventoryManager;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTask extends BaseCommand {
    public CommandTask() {
        super("bajk");
        this.setPermission("MegaWalls.default");
    }

    public String getPossibleArguments() {
        return "";
    }

    public int getMinimumArguments() {
        return 0;
    }

    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        Player player = (Player) sender;
        InventoryManager.TASKMENU.open(player);
        return true;
    }

    public boolean isOnlyPlayerExecutable() {
        return true;
    }
}
