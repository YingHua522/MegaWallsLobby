package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMaster extends BaseCommand {
    public CommandMaster() {
        super("masmas");
        this.setPermission("MegaWalls.admin");
    }

    public String getPossibleArguments() {
        return "give <玩家名> <职业> <数量>";
    }

    public int getMinimumArguments() {
        return 4;
    }

    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        Player player = Bukkit.getPlayer(args[1]);
        if (player == null) {
            sender.sendMessage("§c该玩家不在线！");
        } else {
            Classes classes = ClassesManager.getClassesByName(args[2]);
            if (classes == null) {
                sender.sendMessage("§c该职业不存在！");
            }

            boolean var6 = false;

            int amount;
            try {
                amount = Integer.valueOf(args[3]);
            } catch (NumberFormatException var10) {
                sender.sendMessage("§c请输入有效的数字！");
                return true;
            }

            if (amount <= 0) {
                sender.sendMessage("§c请输入有效的数字！");
            } else {
                GamePlayer reciver = GamePlayer.get(player.getUniqueId());
                KitStatsContainer kitStats = reciver.getPlayerStats().getKitStats(classes);
                int points = kitStats.getMasterPoints() + amount;
                kitStats.setMasterPoints(points);
                MegaWallsLobby.getInstance().getDataBase().dbUpdate("classes_" + classes.getName(), new KeyValue("masterPoints", points), new KeyValue("uuid", reciver.getUuid().toString()));
                sender.sendMessage("§a给予成功！");
            }
        }
        return true;
    }

    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
