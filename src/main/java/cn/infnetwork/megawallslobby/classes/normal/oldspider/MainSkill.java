/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.FallingBlock
 *  org.bukkit.entity.Player
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.Vector
 */
package cn.infnetwork.megawallslobby.classes.normal.oldspider;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public int mode;

    public MainSkill(Classes classes) {
        super("跳跃", classes);
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
        return 5;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 3.0;
            }
            case 2: {
                return 3.5;
            }
            case 3: {
                return 4.0;
            }
            case 4: {
                return 4.5;
            }
            case 5: {
                return 6;
            }
        }
        return 3.0;
    }

    public int getHits(int level) {
        switch (level) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
        }
        return 1;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add(" \u00a78\u25aa \u00a77\u5411\u524d\u8df3\u8dc3\u81f3\u7a7a\u4e2d,\u83b7\u5f975\u79d2\u7684\u751f\u547d");
            lore.add("   \u00a77\u6062\u590dI\u6548\u679c\u3002\u843d\u5730\u65f6,\u5468\u56f4\u654c\u4eba\u53d7");
            lore.add("   \u00a77\u5230\u00a7a" + this.getAttribute(level) + "\u00a77\u70b9\u4f24\u5bb3\u548c\u6301\u7eed4\u79d2\u7684\u7f13\u6162I\u6548\u679c,");
            lore.add("   \u00a77\u4f60\u5219\u83b7\u5f97\u00a7a" + this.getHits(level) + "\u00a77\u6b21\u6bd2\u6db2\u4e4b\u51fb\u7684\u673a\u4f1a\u3002");
            return lore;
        }
        lore.add(" \u00a78\u25aa \u00a77\u5411\u524d\u8df3\u8dc3\u81f3\u7a7a\u4e2d,\u83b7\u5f975\u79d2\u7684\u751f\u547d");
        lore.add("   \u00a77\u6062\u590dI\u6548\u679c\u3002\u843d\u5730\u65f6,\u5468\u56f4\u654c\u4eba\u53d7");
        lore.add("   \u00a77\u5230\u00a78" + this.getAttribute(level - 1) + " \u279c \u00a7a" + this.getAttribute(level) + "\u00a77\u70b9\u4f24\u5bb3\u548c\u6301\u7eed4\u79d2\u7684\u7f13\u6162I\u6548\u679c,");
        lore.add("   \u00a77\u4f60\u5219\u83b7\u5f97\u00a78" + this.getHits(level - 1) + (this.getHits(level - 1) == this.getHits(level) ? "" : " \u279c \u00a7a" + this.getHits(level)) + "\u00a77\u6b21\u6bd2\u6db2\u4e4b\u51fb\u7684\u673a\u4f1a\u3002");
        return lore;
    }

    @Override
    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkillLevel();
    }

    @Override
    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkillLevel();
    }
}

