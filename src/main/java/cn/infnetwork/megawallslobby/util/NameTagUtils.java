package cn.infnetwork.megawallslobby.util;

import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class NameTagUtils {
    public static final Field TEAM_NAME = getAccessibleField(PacketPlayOutScoreboardTeam.class, "a");
    public static final Field DISPLAY_NAME = getAccessibleField(PacketPlayOutScoreboardTeam.class, "b");
    public static final Field PREFIX = getAccessibleField(PacketPlayOutScoreboardTeam.class, "c");
    public static final Field SUFFIX = getAccessibleField(PacketPlayOutScoreboardTeam.class, "d");
    public static final Field PARAM_INT = getAccessibleField(PacketPlayOutScoreboardTeam.class, "h");
    public static final Field PACK_OPTION = getAccessibleField(PacketPlayOutScoreboardTeam.class, "i");
    public static final Field MEMBERS = getAccessibleField(PacketPlayOutScoreboardTeam.class, "g");

    public NameTagUtils() {
    }

    public static PacketPlayOutScoreboardTeam createPacket(String name, String prefix, String suffix) {
        PacketPlayOutScoreboardTeam packet = new PacketPlayOutScoreboardTeam();
        setName(packet, name);
        setDisplayName(packet, name);
        setPrefix(packet, prefix);
        setSuffix(packet, suffix);
        setPackOption(packet);
        return packet;
    }

    public static void sendPacket(Player reciver, PacketPlayOutScoreboardTeam packet) {
        CraftPlayer c = (CraftPlayer) reciver;
        c.getHandle().playerConnection.sendPacket(packet);
    }

    public static void setName(PacketPlayOutScoreboardTeam packet, String teamName) {
        set(TEAM_NAME, packet, teamName);
    }

    public static void setDisplayName(PacketPlayOutScoreboardTeam packet, String teamDisplayName) {
        set(DISPLAY_NAME, packet, teamDisplayName);
    }

    public static void setPrefix(PacketPlayOutScoreboardTeam packet, String teamPrefix) {
        set(PREFIX, packet, teamPrefix);
    }

    public static void setSuffix(PacketPlayOutScoreboardTeam packet, String teamSuffix) {
        set(SUFFIX, packet, teamSuffix);
    }

    public static void setPararmInt(PacketPlayOutScoreboardTeam packet, int paramInt) {
        set(PARAM_INT, packet, paramInt);
    }

    public static void setPackOption(PacketPlayOutScoreboardTeam packet) {
        set(PACK_OPTION, packet, 1);
    }

    public static void addMember(PacketPlayOutScoreboardTeam packet, String player) {
        try {
            ((List) MEMBERS.get(packet)).add(player);
        } catch (IllegalAccessException | IllegalArgumentException var3) {
        }

    }

    public static void set(Field field, Object object, Object value) {
        try {
            field.set(object, value);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static Field getAccessibleField(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            makeAccessible(field);
            return field;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }

    }
}
