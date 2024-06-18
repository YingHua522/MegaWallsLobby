/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.mythic.assassin;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class


MainSkill
        extends Skill {
    public MainSkill(Classes classes) {
        super("暗影披风", classes);
    }

    @Override
    public int maxedLevel() {
        return 5;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 7.2;
            }
            case 2: {
                return 8.4;
            }
            case 3: {
                return 9.6;
            }
            case 4: {
                return 10.8;
            }
            case 5: {
                return 13.0;
            }
        }
        return 3.2;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add("§8• §7Gain Speed II effect for §a" + this.getAttribute(level) + "§7 seconds.");
            lore.add("   §7During this period, you will recover 30% of the damage you caused");
            lore.add("   §7and deal 2 points of true damage when attacking enemies");
            return lore;
        }
        lore.add("§8• §7Gain Speed II effect for §8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7 seconds.");
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

