/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.Vector
 */
package cn.infnetwork.megawallslobby.classes.mythic.lawless;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill
        extends Skill {
    public MainSkill(Classes classes) {
        super("撕裂箭矢", classes);
    }

    @Override
    public int maxedLevel() {
        return 5;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 4.0;
            }
            case 2: {
                return 5.0;
            }
            case 3: {
                return 6.0;
            }
            case 4: {
                return 7.0;
            }
            case 5: {
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
            ;
            lore.add("   §7撕裂敌人身上的箭矢");
            lore.add("   §7并造成§a" + this.getAttribute(level) + "§7点伤害。");
            return lore;
        }
        lore.add("   §7撕裂敌人身上的箭矢");
        lore.add("   §7并造成§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害。");

         */
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

