package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.database.KeyValue;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRejoin extends BaseCommand {
    public CommandRejoin() {
        super("rejoin");
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
        KeyValue keyValue = MegaWallsLobby.getRejoin(GamePlayer.get(player.getUniqueId()));
        if (keyValue != null && !keyValue.getString("server").equalsIgnoreCase("none")) {
            if (System.currentTimeMillis() > Long.parseLong(keyValue.getString("time"))) {
                player.sendMessage("§c无法重新加入游戏。请不要担心,这通常发生在上一场游戏已经结束的情况下。");
                return true;
            }

            String server1 = keyValue.getString("server");
            String server = MegaWallsLobby.getInstance().getDataBase().dbSelectFirst("megawalls_servers", "bc", new KeyValue("server", server1));
            player.sendMessage("§a正在将你重新连接至:§e" + server1);
            MegaWallsLobby.tpServer(player, server);
        } else {
            player.sendMessage("§c无法重新加入游戏。请不要担心,这通常发生在上一场游戏已经结束的情况下。");
        }
        return true;
    }

    public boolean isOnlyPlayerExecutable() {
        return true;
    }
}
