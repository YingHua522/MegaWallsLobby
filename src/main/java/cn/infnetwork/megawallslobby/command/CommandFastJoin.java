package cn.infnetwork.megawallslobby.command;
/*
 * @Author huanmeng_qwq
 * @Date 2020/8/22 21:26
 * MegaWallsLobby
 */

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.game.Server;
import cn.infnetwork.megawallslobby.inventory.InventoryManager;
import cn.infnetwork.megawallslobby.inventory.MatchServerMenu;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

@SuppressWarnings("all")
public class CommandFastJoin extends BaseCommand {
    public CommandFastJoin() {
        super("fastjoin");
        setPermission("MegaWalls.fastjoin");
    }

    public CommandFastJoin(String name) {
        super(name);
    }

    public static Server fastJoin() {
        HashMap<Server, Integer> slist = new HashMap<>();
        List<Server> sorted = new ArrayList<>();
        for (Server server : MatchServerMenu.getWaitServer()) {
            slist.put(server, server.getOnline());
        }
        List<Map.Entry<Server, Integer>> maplist = new ArrayList<Map.Entry<Server, Integer>>(slist.entrySet());
        Collections.sort(maplist, new Comparator<Map.Entry<Server, Integer>>() {
            @Override
            public int compare(Map.Entry<Server, Integer> o1, Map.Entry<Server, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        LinkedHashMap<String, Integer> s = new LinkedHashMap<String, Integer>();
        List<Server> ser = new ArrayList<>();
        for (int i = 0; i < maplist.size(); i++) {
            Map.Entry<Server, Integer> x = maplist.get(i);
            sorted.add(x.getKey());
        }
        return sorted.get(0);
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
        if (args.length == 0) {
            MegaWallsLobby.tpServer(((Player) sender), MegaWallsLobby.translateServerByGame(fastJoin()));
        } else if (args.length == 1 && args[0].equalsIgnoreCase("gui")) {
            InventoryManager.MATCHSERVERMENU.open(((Player) sender));
        }
        return true;
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return true;
    }
}
