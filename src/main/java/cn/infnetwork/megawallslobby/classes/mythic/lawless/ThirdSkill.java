/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package cn.infnetwork.megawallslobby.classes.mythic.lawless;


import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill
        extends Skill {
    public ThirdSkill(Classes classes) {
        super("掠夺", classes);
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 7;
            }
            case 2: {
                return 6;
            }
            case 3: {
                return 5;
            }
        }
        return 7;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add(" §8▪ §7死斗时,击杀§a" + this.getAttribute(level) + "§7名玩家");
            lore.add("   §7掉落&a不法者药");
            return lore;
        }
        lore.add(" §8▪ §7死斗时,击杀§a" + this.getAttribute(level) + "§7名玩家");
        lore.add("   §7掉落&a不法者药");

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

