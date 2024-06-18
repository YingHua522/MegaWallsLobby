/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.mythic.lawless;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    Location location;

    public SecondSkill(Classes classes) {
        super("抓钩", classes);
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
                return 0.2;
            }
            case 3: {
                return 0.3;
            }
        }
        return 0.1;
    }

    public int getSpeed(int level) {
        switch (level) {
            case 1:
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
        }
        return 1;
    }

    public int getDig(int level) {
        switch (level) {
            case 1: {
                return 1;
            }
            case 2:
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
            lore.add(" §8▪ §7消耗§e60§7点能量");
            lore.add("   §7释放一个抓钩,冷却30秒");
            return lore;
        }
        lore.add(" §8▪ §7消耗§e60§7点能量");
        lore.add("   §7释放一个抓钩，冷却30秒");

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

