/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.World
 *  org.bukkit.Bukkit
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 */
package cn.infnetwork.megawallslobby.classes.mythic.snowman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {

    public SecondSkill(Classes classes) {
        super("暴风雪", classes);
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 0.5;
            }
            case 2: {
                return 0.75;
            }
            case 3: {
                return 1.0;
            }
        }
        return 0.5;
    }

    public int getAmount(int level) {
        switch (level) {
            case 1: {
                return 1;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
        }
        return 1;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        /*
        if (level == 1) {
            lore.add("§8• §7击杀敌人时有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7生成§a" + this.getAmount(level) + "个烈焰人。");
            return lore;
        }
        lore.add("§8• §7击杀敌人时有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
        lore.add("   §7生成§8" + (this.getAmount(level - 1) == this.getAmount(level) ? Integer.valueOf(this.getAmount(level)) : this.getAmount(level - 1) + " ➜ §a" + this.getAmount(level)) + "§7个烈焰人。");

         */
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

