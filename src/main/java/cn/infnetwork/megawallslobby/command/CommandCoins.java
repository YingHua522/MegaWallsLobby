package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.game.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandCoins extends BaseCommand {
    public CommandCoins() {
        super("sdsa");
        this.setPermission("MegaWalls.coins");
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
            assert gamePlayer != null;
            player.sendMessage("§a当前硬币: " + gamePlayer.getPlayerStats().getCoins());
        } else if (args[0].equalsIgnoreCase("give") && args.length >= 3) {
            player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                sender.sendMessage("§a该玩家不在线!");
                return true;
            }

            int amount;
            try {
                amount = Integer.parseInt(args[2]);
            } catch (NumberFormatException var7) {
                sender.sendMessage("§c请输入有效的数量!");
                return true;
            }

            if (amount <= 0) {
                sender.sendMessage("§c请输入有效的数量!");
                return true;
            }

            GamePlayer reciver = GamePlayer.get(player.getUniqueId());
            assert reciver != null;
            reciver.getPlayerStats().giveCoins(amount);
            sender.sendMessage("§a" + args[1] + "当前硬币: " + reciver.getPlayerStats().getCoins());
        }
        return true;
    }

    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
