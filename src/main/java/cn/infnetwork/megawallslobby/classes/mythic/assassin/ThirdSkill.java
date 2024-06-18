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
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill
        extends Skill {
    public ThirdSkill(Classes classes) {
        super("暗影步伐", classes);
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 0.8;
            }
            case 2: {
                return 0.9;
            }
            case 3: {
                return 1.0;
            }
        }
        return 0.8;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<>();
        /*
        if (level == 1) {
            lore.add("§8• §7When eating Steak, there is a §a" + StringUtils.percent(this.getAttribute(level)) + "§7 chance to gain");
            lore.add("   §775 seconds of Health Regeneration I effect.");
            return lore;
        }
        lore.add("§8• §7When eating Steak, there is a §8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
        lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7 chance to gain");
        lore.add("   §775 seconds of Health Regeneration I effect.");
        return lore;

         */
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

