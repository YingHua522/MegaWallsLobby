package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandHandler implements CommandExecutor, TabCompleter {
    private List<BaseCommand> commands = new ArrayList();

    public CommandHandler() {
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandRejoin());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandMaster());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandCoins());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandClasses());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandDust());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandShop());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandTask());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandActiveMode());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandServers());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandFastJoin());
        this.registerCommand(MegaWallsLobby.getInstance(), new CommandVoteMap());
        this.registerCommand(MegaWallsLobby.getInstance(),new CommandSkin());
        this.registerCommand(MegaWallsLobby.getInstance(),new CommandMythicMode());
        //this.registerCommand(MegaWallsLobby.getInstance(),new CommandClassesNPC());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Iterator var5 = this.commands.iterator();

        while (true) {
            BaseCommand command;
            do {
                if (!var5.hasNext()) {
                    return false;
                }

                command = (BaseCommand) var5.next();
            } while (!command.isValidTrigger(cmd.getName()));

            if (!command.hasPermission(sender)) {
                sender.sendMessage("§fUnknown command. Type \"/help\" for help.");
                return true;
            }

            if (command.isOnlyPlayerExecutable() && !(sender instanceof Player)) {
                sender.sendMessage("§c控制台无法使用此命令！");
                return true;
            }
            if (args.length >= command.getMinimumArguments()) {
                try {
                    command.execute(sender, label, args);
                    return true;
                } catch (CommandException var8) {
                }
            } else {
                sender.sendMessage("§c错误的参数: /" + command.getName() + " " + command.getPossibleArguments());
            }
        }
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

    public void registerCommand(JavaPlugin plugin, BaseCommand command) {
        this.commands.add(command);
        MinecraftServer.getServer().server.getCommandMap().register(command.getName(), plugin.getName(), command);
        //plugin.getCommand(command.getName()).setExecutor(this);
        //plugin.getCommand(command.getName()).setTabCompleter(this);
    }
}
