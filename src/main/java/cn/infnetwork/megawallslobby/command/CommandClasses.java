//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClasses extends BaseCommand {
    public CommandClasses() {
        super("jcslas");
        this.setPermission("MegaWalls.classes");
    }

    public String getPossibleArguments() {
        return "give <玩家名> <职业名>";
    }

    public int getMinimumArguments() {
        return 3;
    }

    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        if (args[0].equalsIgnoreCase("give") && args.length >= 3) {
            Player player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                sender.sendMessage("§a该玩家不在线!");
                return true;
            }

            Classes classes = ClassesManager.getClassesByName(args[2]);
            if (classes == null) {
                sender.sendMessage("§c该职业不存在！");
            }

            GamePlayer reciver = GamePlayer.get(player.getUniqueId());
            KitStatsContainer kitStats = reciver.getPlayerStats().getKitStats(classes);
            if (kitStats.getLevel() == 0) {
                kitStats.addLevel();
                sender.sendMessage("§a成功给予玩家" + classes.getDisplayName() + "职业！");
                return true;
            }

            sender.sendMessage("§c玩家已拥有该职业！");
        }
        return true;
    }

    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
