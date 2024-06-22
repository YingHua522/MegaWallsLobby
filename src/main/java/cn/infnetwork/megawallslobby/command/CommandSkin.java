package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.inventory.InventoryManager;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSkin extends BaseCommand{
    public CommandSkin() {
        super("mwskin");
        this.setPermission("MegaWalls.default");
    }

    @Override
    public String getPossibleArguments() {
        return null;
    }

    @Override
    public int getMinimumArguments() {
        return 0;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        Player player = (Player) sender;
        GamePlayer gamePlayer = GamePlayer.get(player.getUniqueId());
        if (gamePlayer != null) {
            InventoryManager.SKINMENU.open(player);
        }
        return true;
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return true;
    }
}
