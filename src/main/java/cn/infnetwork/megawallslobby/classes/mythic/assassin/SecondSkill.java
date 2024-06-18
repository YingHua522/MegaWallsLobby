/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.entity.Player
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

public class SecondSkill
        extends Skill {
    public SecondSkill(Classes classes) {
        super("箭矢吸收", classes);
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 4.0;
            }
            case 2: {
                return 6.0;
            }
            case 3: {
                return 8.0;
            }
        }
        return 4.0;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        /*
        if (level == 1) {
            lore.add("§8• §7When continuously attacking or hitting an enemy with an arrow,");
            lore.add("   §7and not taking any damage, you will gain a continuous");
            lore.add("   §a" + this.getAttribute(level) + "§7 seconds of Speed I and Resistance II effect.");
            return lore;
        }
        lore.add("§8• §7When continuously attacking or hitting an enemy with an arrow,");
        lore.add("   §7and not taking any damage, you will gain a continuous");
        lore.add("   §8" + this.getAttribute(level - 1) + " ➜");
        lore.add("   §a" + this.getAttribute(level) + "§7 seconds of Speed I and Resistance II effect.");

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

