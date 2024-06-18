package cn.infnetwork.megawallslobby.command;
/*
 * @Author huanmeng_qwq
 * @Date 2020/8/22 22:52
 * MegaWallsLobby
 */

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class CommandVoteMap extends BaseCommand {
    public CommandVoteMap() {
        super("votemap");
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
        if (args.length == 1 && player.hasPermission("MegaWalls.votemap." + args[0])) {
            MegaWallsLobby.voteMap(args[0], 1);
            player.sendMessage("§a投票成功");
        }
        return true;
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return true;
    }
}
