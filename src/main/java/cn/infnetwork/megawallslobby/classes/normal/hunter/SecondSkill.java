package cn.infnetwork.megawallslobby.classes.normal.hunter;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("动物伙伴", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.1D;
            case 2:
                return 0.15D;
            case 3:
                return 0.2D;
            default:
                return 0.1D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你被攻击,你将有§a" + StringUtils.percent(this.getAttribute(level)) + "§7的");
            lore.add("   §7几率召唤一只随机宠物。");
            lore.add("   §7它可能是:鸡骑士、皮皮猪、");
            lore.add("   §7蜘蛛、爆炸羊或狼。");
            return lore;
        } else {
            lore.add(" §8▪ §7当你被攻击,你将有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7的");
            lore.add("   §7几率召唤一只随机宠物。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill2Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill2Level();
    }
}
