package cn.infnetwork.megawallslobby.effect;

import cn.infnetwork.megawallslobby.classes.Upgradeable;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.*;

public class KillMessage implements Upgradeable {
    public static final KillMessage DEFAULT;

    static {
        Map<String, String> messages = new HashMap();
        messages.put("Arrow", "被射杀");
        messages.put("Snowball", "被雪球砸死");
        messages.put("Attack", "被击杀");
        messages.put("Poison", "被毒药杀死");
        messages.put("Explode", "被炸死");
        messages.put("Magic", "被魔法杀死");
        DEFAULT = new KillMessage("Default", "默认", 0, messages);
    }

    private String name;
    private String displayName;
    private int price;
    private Map<String, String> messages;

    public KillMessage(String name, String displayName, int price, Map<String, String> messages) {
        this.name = name;
        this.displayName = displayName;
        this.price = price;
        this.messages = messages;
    }

    public String getMessage(String cause) {
        return (String) this.messages.getOrDefault(cause, "被击杀");
    }

    public int maxedLevel() {
        return 0;
    }

    public double getAttribute(int level) {
        return 0.0D;
    }

    public List<String> getInfo(int level) {
        List<String> list = new ArrayList();
        list.add("§7解锁§c" + this.displayName + "§7击杀信息。");
        list.add(" ");
        Iterator var3 = this.messages.values().iterator();

        while (var3.hasNext()) {
            String message = (String) var3.next();
            list.add("§e玩家 §f" + message + ",击杀者: §e你");
        }

        return list;
    }

    public void upgrade(GamePlayer gamePlayer) {
        gamePlayer.getPlayerStats().getEffectStats().updateKillMessage(this.name);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + gamePlayer.getName() + " permission set MegaWalls.killmessage." + this.name);
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return 0;
    }

    public Material getIconType() {
        return Material.PAPER;
    }

    public byte getIconData() {
        return 0;
    }

    public int getCost(int level) {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getPrice() {
        return this.price;
    }
}
