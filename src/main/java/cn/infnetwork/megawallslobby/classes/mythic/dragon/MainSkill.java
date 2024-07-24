/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Sound
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.WitherSkull
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package cn.infnetwork.megawallslobby.classes.mythic.dragon;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import java.util.ArrayList;
import java.util.List;

public class MainSkill
extends Skill {
    public MainSkill(Classes classes) {
        super("炽热吐息", classes);
    }
    @Override
    public int maxedLevel() {
        return 5;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 5.0;
            }
            case 2: {
                return 5.5;
            }
            case 3: {
                return 6.0;
            }
            case 4: {
                return 6.5;
            }
            case 5: {
                return 7.0;
            }
        }
        return 5.0;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add(" \u00a78\u25aa \u00a77\u4e00\u6b21\u53d1\u5c04\u4e09\u4e2a\u51cb\u96f6\u9ab7\u9ac5,");
            lore.add("   \u00a77\u6bcf\u4e2a\u9020\u6210\u00a7a" + this.getAttribute(level) + "\u00a77\u70b9\u4f24\u5bb3\u3002");
            return lore;
        }
        lore.add(" \u00a78\u25aa \u00a77\u4e00\u6b21\u53d1\u5c04\u4e09\u4e2a\u51cb\u96f6\u9ab7\u9ac5,");
        lore.add("   \u00a77\u6bcf个\u9020\u6210\u00a78" + this.getAttribute(level - 1) + " \u279c \u00a7a" + this.getAttribute(level) + "\u00a77\u70b9\u4f24\u5bb3\u3002");
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

