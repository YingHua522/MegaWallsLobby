/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.Sound
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Fireball
 *  org.bukkit.entity.Player
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package cn.infnetwork.megawallslobby.classes.mythic.snowman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("寒冰之刺", classes);
    }

    @Override
    public int maxedLevel() {
        return 5;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 1.33;
            }
            case 2: {
                return 1.67;
            }
            case 3: {
                return 2.0;
            }
            case 4: {
                return 2.33;
            }
            case 5: {
                return 2.67;
            }
        }
        return 1.33;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        /*
        if (level == 1) {
            lore.add("§8• §7发射3颗火球，每颗");
            lore.add("   §7爆炸造成§a" + this.getAttribute(level) + "§7点伤害。");
            return lore;
        }
        lore.add("§8• §7发射3颗火球，每颗");
        lore.add("   §7爆炸造成§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害。");

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

