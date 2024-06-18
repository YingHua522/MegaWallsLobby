package cn.infnetwork.megawallslobby.game;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesManager;
import cn.infnetwork.megawallslobby.stats.PlayerStats;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class GamePlayer {
    private static final List<GamePlayer> gamePlayers = new ArrayList();
    private final UUID uuid;
    private final String name;
    private final String displayName;
    private PlayerStats playerStats;
    private GamePlayer.TopToggle topToggle;

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
        this.name = this.getPlayer().getName();
        this.displayName = ChatColor.stripColor(this.getPlayer().getDisplayName());
        this.playerStats = new PlayerStats(this);
        this.topToggle = new GamePlayer.TopToggle(this);
    }

    public static GamePlayer create(UUID uuid) {
        GamePlayer gamePlayer = get(uuid);
        if (gamePlayer != null) {
            return gamePlayer;
        } else {
            gamePlayer = new GamePlayer(uuid);
            gamePlayers.add(gamePlayer);
            return gamePlayer;
        }
    }

    public static void remove(UUID uuid) {
        if (get(uuid) != null) {
            gamePlayers.remove(get(uuid));
        }

    }

    public static GamePlayer get(UUID uuid) {
        Iterator var1 = gamePlayers.iterator();

        GamePlayer gamePlayer;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            gamePlayer = (GamePlayer) var1.next();
        } while (!gamePlayer.getUuid().equals(uuid));

        return gamePlayer;
    }

    public static List<GamePlayer> getGamePlayers() {
        return new ArrayList(gamePlayers);
    }

    public static List<GamePlayer> getOnlinePlayers() {
        List<GamePlayer> onlinePlayers = new ArrayList();
        Iterator var1 = gamePlayers.iterator();

        while (var1.hasNext()) {
            GamePlayer gamePlayer = (GamePlayer) var1.next();
            if (gamePlayer.isOnline()) {
                onlinePlayers.add(gamePlayer);
            }
        }

        return onlinePlayers;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(this.getUuid());
    }

    public boolean isOnline() {
        return this.getPlayer() != null && this.getPlayer().isOnline();
    }

    public void sendActionBar(String message) {
        if (this.isOnline()) {
            message = ChatColor.translateAlternateColorCodes('&', message);
            PlayerConnection connection = ((CraftPlayer) this.getPlayer()).getHandle().playerConnection;
            IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
            PacketPlayOutChat ppoc = new PacketPlayOutChat(icbc, (byte) 2);
            connection.sendPacket(ppoc);
        }
    }

    public void sendTitle(String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        if (this.isOnline()) {
            PlayerConnection connection = ((CraftPlayer) this.getPlayer()).getHandle().playerConnection;
            IChatBaseComponent titleSub;
            PacketPlayOutTitle packetPlayOutSubTitle;
            if (title != null) {
                title = ChatColor.translateAlternateColorCodes('&', title);
                titleSub = ChatSerializer.a("{\"text\": \"" + title + "\"}");
                packetPlayOutSubTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleSub);
                connection.sendPacket(packetPlayOutSubTitle);
            }

            if (subTitle != null) {
                subTitle = ChatColor.translateAlternateColorCodes('&', subTitle);
                titleSub = ChatSerializer.a("{\"text\": \"" + subTitle + "\"}");
                packetPlayOutSubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, titleSub);
                connection.sendPacket(packetPlayOutSubTitle);
            }

        }
    }

    public void sendMessage(String message) {
        if (this.isOnline()) {
            message = ChatColor.translateAlternateColorCodes('&', message);
            this.getPlayer().sendMessage(message);
        }
    }

    public void playSound(Sound sound, float volume, float pitch) {
        if (this.isOnline()) {
            this.getPlayer().playSound(this.getPlayer().getLocation(), sound, volume, pitch);
        }
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public PlayerStats getPlayerStats() {
        return this.playerStats;
    }

    public GamePlayer.TopToggle getTopToggle() {
        return this.topToggle;
    }

    public static class TopToggle {
        public static final List<Classes> classesList = new ArrayList(ClassesManager.getClasses());
        private GamePlayer gamePlayer;
        private int index = 0;

        public TopToggle(GamePlayer gamePlayer) {
            this.gamePlayer = gamePlayer;
        }

        public Classes now() {
            return (Classes) classesList.get(this.index);
        }

        public void next() {
            ++this.index;
            if (this.index >= classesList.size()) {
                this.index = 0;
            }

        }

        public GamePlayer getGamePlayer() {
            return this.gamePlayer;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
