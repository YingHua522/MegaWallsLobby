/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.event.block.BlockBreakEvent
 */
package cn.infnetwork.megawallslobby.classes.mythic.assassin;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
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
                return 0.6;
            }
            case 2: {
                return 0.8;
            }
            case 3: {
                return 1.0;
            }
        }
        return 0.6;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<>();
        if (level == 1) {
            lore.add("§8• §7你可以吸收正前方射出的箭矢.");
            lore.add("    §7每吸收§a1§7个箭矢，如果你的背包未满，则获得§a1根箭矢");
        } else if (level == 2) {
            lore.add("§8• §7你可以吸收正前方射出的箭矢.");
            lore.add("    §7每吸收§a1§7个箭矢，如果你的背包未满，则获得§a2根箭矢");
        } else if (level == 3) {
            lore.add("§8• §7你可以吸收正前方射出的箭矢.");
            lore.add("    §7每吸收§a1§7个箭矢，如果你的背包未满，则获得§a3根箭矢");
        }
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

