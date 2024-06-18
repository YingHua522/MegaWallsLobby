package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import org.bukkit.Sound;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

public class CommandMythicMode extends BaseCommand{
    public CommandMythicMode() {
        super("mythic");
        this.setPermission("MegaWalls.admin");
    }

    public String getPossibleArguments() {
        return null;
    }

    public int getMinimumArguments() {
        return 0;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) throws CommandException {
        if (args.length == 1) {
            try {
                int hours = Integer.parseInt(args[0]);
                if (hours >= 0) {
                    long time = System.currentTimeMillis() + 3600000L * (long) hours;
                    MegaWallsLobby.setBooster(2);
                    MegaWallsLobby.setMythicMode(time);
                    sender.sendMessage("§e神话游戏" + (hours == 0 ? "关闭" : "开启") + "！");
                    if (hours > 0) {
                        for (GamePlayer gamePlayer : GamePlayer.getOnlinePlayers()) {
                            gamePlayer.sendTitle("§e神话游戏", "§6随机职业满级，双倍硬币已开启！", 20, 40, 20);
                            gamePlayer.playSound(Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
                        }
                    }

                }
            } catch (Exception var9) {
                sender.sendMessage("§c请输入有效的时间！");
            }
        } else if (args.length == 2) {
            try {
                int hours = Integer.parseInt(args[0]);
                int booster = Integer.parseInt(args[1]);
                if (hours >= 0) {
                    long time = System.currentTimeMillis() + 3600000L * (long) hours;
                    MegaWallsLobby.setBooster(booster);
                    MegaWallsLobby.setMythicMode(time);
                    sender.sendMessage("§e神话游戏" + (hours == 0 ? "关闭" : "开启") + "！");
                    if (hours > 0) {
                        for (GamePlayer gamePlayer : GamePlayer.getOnlinePlayers()) {
                            gamePlayer.sendTitle("§e神话游戏", "§6随机职业满级，" + booster + "硬币已开启！", 20, 40, 20);
                            gamePlayer.playSound(Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
                        }
                    }

                }
            } catch (Exception var9) {
                sender.sendMessage("§c请输入有效的时间！");
            }
        }
        return true;
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
