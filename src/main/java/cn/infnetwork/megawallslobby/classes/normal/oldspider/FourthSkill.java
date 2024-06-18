/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.block.Chest
 *  org.bukkit.entity.Firework
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.inventory.ItemStack
 */
package cn.infnetwork.megawallslobby.classes.normal.oldspider;


import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("寻铁者", classes);
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
        ArrayList<String> lore = new ArrayList<String>();
        if (level == 1) {
            lore.add(" \u00a78\u25aa \u00a77\u5f53\u91c7\u96c6\u6ce5\u571f\u3001\u8349\u3001\u6c99\u5b50\u3001");
            lore.add("    \u00a77\u7802\u783e\u6216\u83cc\u4e1d\u65f6,");
            lore.add("    \u00a77\u6709\u00a7a" + StringUtils.percent(this.getAttribute(level)) + "\u00a77\u51e0\u7387\u83b7\u5f97\u94c1\u952d\u3002");
            return lore;
        }
        lore.add(" \u00a78\u25aa \u00a77\u5f53\u91c7\u96c6\u6ce5\u571f\u3001\u8349\u3001\u6c99\u5b50\u3001");
        lore.add("    \u00a77\u7802\u783e\u6216\u83cc\u4e1d\u65f6,");
        lore.add("    \u00a77\u6709\u00a78" + StringUtils.percent(this.getAttribute(level - 1)) + " \u279c \u00a7a" + StringUtils.percent(this.getAttribute(level)) + "\u00a77\u51e0\u7387\u83b7\u5f97\u94c1\u952d\u3002");
        return lore;
    }

    @Override
    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill4Level();
    }

    @Override
    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill4Level();
    }
}

