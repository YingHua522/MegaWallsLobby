package cn.infnetwork.megawallslobby.classes.normal.arcane;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("奥术爆炸", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.14D;
            case 2:
                return 0.17D;
            case 3:
                return 0.2D;
            default:
                return 0.14D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7被攻击时,有§a" + StringUtils.percent(this.getAttribute(level)) + "§7的几率发动奥术爆炸");
            lore.add("   §7对你周围的敌人造成1次伤害");
            return lore;
        } else {
            lore.add(" §8▪ §7被攻击时,有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7的几率发动奥术爆炸");
            lore.add("   §7对你周围的敌人造成1次伤害");
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