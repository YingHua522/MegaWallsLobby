package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.inventory.InventoryManager;
import cn.infnetwork.megawallslobby.inventory.SkinMenu;
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
            SkinMenu.createSkinSelectionMenu(ClassesManager.getSelected(gamePlayer), InventoryManager.SHOPMENU, gamePlayer).open(player);
        }
        return true;
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return true;
    }
}
