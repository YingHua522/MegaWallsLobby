package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.game.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandDust extends BaseCommand {
    public CommandDust() {
        super("njksa");
        this.setPermission("MegaWalls.dust");
    }

    public String getPossibleArguments() {
        return "give <玩家名> <数量>";
    }

    public int getMinimumArguments() {
        return 0;
    }

    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        Player player;
        if (args.length == 0 & !(sender instanceof ConsoleCommandSender)) {
            player = (Player) sender;
            GamePlayer gamePlayer = GamePlayer.get(player.getUniqueId());
            if (gamePlayer != null) {
                sender.sendMessage("§a当前神话之尘: " + gamePlayer.getPlayerStats().getMythicDust());
            }
        } else if (args[0].equalsIgnoreCase("give") && args.length >= 3) {
            player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                sender.sendMessage("§a该玩家不在线!");
                return true;
            }

            int amount;
            try {
                amount = Integer.valueOf(args[2]);
            } catch (NumberFormatException var7) {
                sender.sendMessage("§c请输入有效的数量!");
                return true;
            }

            if (amount <= 0) {
                sender.sendMessage("§c请输入有效的数量!");
                return true;
            }

            GamePlayer reciver = GamePlayer.get(player.getUniqueId());
            reciver.getPlayerStats().giveMythicDust(amount);
            sender.sendMessage("§a" + args[1] + "当前神话之尘: " + reciver.getPlayerStats().getMythicDust());
        }
        return true;
    }

    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
