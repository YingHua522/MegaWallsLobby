/*
 * Decompiled with CFR 0.152.
 */
package cn.infnetwork.megawallslobby.classes.mythic.snowman;


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
        super("雪人伙伴", classes);
    }

    @Override
    public int maxedLevel() {
        return 3;
    }

    @Override
    public double getAttribute(int level) {
        switch (level) {
            case 1: {
                return 0.05;
            }
            case 2: {
                return 0.075;
            }
            case 3: {
                return 0.1;
            }
        }
        return 0.05;
    }

    @Override
    public List<String> getInfo(int level) {
        ArrayList<String> lore = new ArrayList<String>();
        /*
        if (level == 1) {
            lore.add("§8• §7攻击敌人时有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率将其点燃3秒。");
            lore.add("   §7BowArrow命中时几率加倍。");
            lore.add("   §7触发时获得生命恢复。");
            lore.add(" ");
            lore.add("§7冷却时间:§a1秒");
            return lore;
        }
        lore.add("§8• §7攻击敌人时有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率将其点燃3秒。");
        lore.add("   §7BowArrow命中时几率加倍。");
        lore.add("   §7触发时获得生命恢复。");

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

