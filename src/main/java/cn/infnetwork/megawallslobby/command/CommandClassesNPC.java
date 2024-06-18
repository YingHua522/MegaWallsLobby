package cn.infnetwork.megawallslobby.command;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandClassesNPC extends BaseCommand{
    public CommandClassesNPC() {
        super("classesnpc");
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
        if (sender instanceof org.bukkit.entity.Player) {
            Player commandSender = (Player) sender;
            GamePlayer gamePlayer = GamePlayer.get(commandSender.getUniqueId());
            if (gamePlayer == null) {
                return false;
            }
            NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, gamePlayer.getUuid(), new Random().nextInt(100000), "1");
            npc.spawn(commandSender.getLocation());
            for (Player player : Bukkit.getOnlinePlayers()) {
                GamePlayer eachPlayer = GamePlayer.get(player.getUniqueId());
                if (eachPlayer == null) {
                    continue;
                }
                Hologram hologram = HologramsAPI.createHologram(MegaWallsLobby.getInstance(), npc.getStoredLocation().add(0.0, 3.0, 0.0));
                hologram.appendTextLine(eachPlayer.getPlayerStats().getSelected().getDisplayName() + "§b预览");
                hologram.getVisibilityManager().resetVisibilityAll();
                hologram.getVisibilityManager().showTo(player);
            }
            return true;
        }
        return true;
    }


    public static void updateNPCAndHologram(NPC npc, String allClasses) {
        for (Hologram hologram : HologramsAPI.getHolograms(MegaWallsLobby.getInstance())) {
            if (hologram.getLocation().equals(npc.getStoredLocation().add(0.0, 3.0, 0.0))) {
                hologram.delete();
                break;
            }
        }
        Hologram newHologram = HologramsAPI.createHologram(MegaWallsLobby.getInstance(), npc.getStoredLocation().add(0.0, 3.0, 0.0));
        newHologram.appendTextLine(allClasses + "§b预览");
    }

    @Override
    public boolean isOnlyPlayerExecutable() {
        return false;
    }
}
