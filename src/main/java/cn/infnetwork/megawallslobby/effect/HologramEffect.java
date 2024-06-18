package cn.infnetwork.megawallslobby.effect;

import cn.infnetwork.megawallslobby.classes.Upgradeable;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class HologramEffect implements Upgradeable {
    public static final HologramEffect DEFAULT = new HologramEffect("Default", "无", 0);
    private String name;
    private String line;
    private int price;

    public HologramEffect(String name, String line, int price) {
        this.name = name;
        this.line = line;
        this.price = price;
    }

    public int maxedLevel() {
        return 0;
    }

    public double getAttribute(int level) {
        return 0.0D;
    }

    public List<String> getInfo(int level) {
        return Arrays.asList("§7所有的凋零死亡后,每击", "§7杀一个敌人都会在其坟墓", "§7上放置一张全息图。");
    }

    public void upgrade(GamePlayer gamePlayer) {
        gamePlayer.getPlayerStats().getEffectStats().updateHologramEffect(this.name);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + gamePlayer.getName() + " permission set MegaWalls.hologrameffect." + this.name);
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return 0;
    }

    public Material getIconType() {
        return Material.SIGN;
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

    public String getLine() {
        return this.line;
    }

    public int getPrice() {
        return this.price;
    }
}
