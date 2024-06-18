/*
 * Decompiled with CFR 0.152.
 */
package cn.infnetwork.megawallslobby.classes.normal.oldspider;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("飞掠", classes);
    }

    public static List<Block> getSphere(Location location, int radius) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        int X = location.getBlockX();
        int Y = location.getBlockY();
        int Z = location.getBlockZ();
        int radiusSquared = radius * radius;
        for (int x = X - radius; x <= X + radius; ++x) {
            for (int z = Z - radius; z <= Z + radius; ++z) {
                if ((X - x) * (X - x) + (Z - z) * (Z - z) > radiusSquared) continue;
                blocks.add(location.getWorld().getBlockAt(x, Y, z));
            }
        }
        return blocks;
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 0.1;
            }
            case 2: {
                return 0.15;
            }
            case 3: {
                return 0.2;
            }
        }
        return 0.1;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add(" \u00a78\u25aa \u00a77\u53d7\u5230\u6454\u843d\u4f24\u5bb3,\u6bcf\u635f\u5931\u4e00\u9897\u5fc3\u7684\u751f\u547d\u503c,");
            lore.add("   \u00a77\u83b7\u5f97\u00a7a" + StringUtils.percent(this.getAttribute(level)) + "\u00a77\u7684\u4f24\u5bb3\u52a0\u6210(\u6700\u591a4\u6b21)");
            return lore;
        }
        lore.add(" \u00a78\u25aa \u00a77\u53d7\u5230\u6454\u843d\u4f24\u5bb3,\u6bcf\u635f\u5931\u4e00\u9897\u5fc3\u7684\u751f\u547d\u503c,");
        lore.add("   \u00a77\u83b7\u5f97\u00a78" + StringUtils.percent(this.getAttribute(level - 1)) + " \u279c \u00a7a" + StringUtils.percent(this.getAttribute(level)) + "\u00a77\u7684\u4f24\u5bb3\u52a0\u6210(\u6700\u591a4\u6b21)");
        return lore;
    }

    @Override
    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill2Level();
    }

    @Override
    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill2Level();
    }
}

