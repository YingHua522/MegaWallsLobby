package cn.infnetwork.megawallslobby.command;
/*
 * @Author huanmeng_qwq
 * @Date 2020/8/21 23:09
 * MegaWallsLobby
 */

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.database.KeyValue;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

@SuppressWarnings("all")
public class CommandServers extends BaseCommand {
    public CommandServers() {
        super("bns");
        setPermission("MegaWalls.admin");
    }

    @Override
    public String getPossibleArguments() {
        return "<room name> <bc name>";
    }

    @Override
    public int getMinimumArguments() {
        return 2;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        if (args.length == 2) {
            MegaWallsLobby.getInstance().getDataBase().dbInsert("megawalls_servers", new KeyValue("server", args[0]).add("bc", args[1]));
        }
        return true;
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
