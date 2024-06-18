/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.normal.oldspider;


import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {

    public ThirdSkill(Classes classes) {
        super("毒液之击", classes);
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 3.0;
            }
            case 2: {
                return 4.0;
            }
            case 3: {
                return 5.0;
            }
        }
        return 3.0;
    }


    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add(" \u00a78\u25aa \u00a77死亡后生成蜘蛛");
            return lore;
        }
        lore.add(" \u00a78\u25aa \u00a77死亡后生成蜘蛛");
        return lore;
    }

    @Override
    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill3Level();
    }

    @Override
    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill3Level();
    }

}

