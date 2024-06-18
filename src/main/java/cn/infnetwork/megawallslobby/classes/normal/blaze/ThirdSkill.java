package cn.infnetwork.megawallslobby.classes.normal.blaze;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("熔融之心", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.05D;
            case 2:
                return 0.075D;
            case 3:
                return 0.1D;
            default:
                return 0.05D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7攻击敌人时有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率将其点燃3秒。");
            lore.add("   §7弓箭命中时几率加倍。");
            lore.add("   §7触发时获得生命恢复。");
            lore.add(" ");
            lore.add("§7冷却时间:§a1秒");
            return lore;
        } else {
            lore.add(" §8▪ §7攻击敌人时有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率将其点燃3秒。");
            lore.add("   §7弓箭命中时几率加倍。");
            lore.add("   §7触发时获得生命恢复。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill3Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill3Level();
    }
}
