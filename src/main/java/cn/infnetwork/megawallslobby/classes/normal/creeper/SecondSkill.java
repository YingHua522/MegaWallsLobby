package cn.infnetwork.megawallslobby.classes.normal.creeper;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("裂变心脏", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.3333D;
            case 2:
                return 0.6667D;
            case 3:
                return 1.0D;
            default:
                return 0.3333D;
        }
    }

    public double getDamage(int level) {
        switch (level) {
            case 1:
                return 0.5D;
            case 2:
                return 0.75D;
            case 3:
                return 1.0D;
            default:
                return 0.5D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7被击杀时,有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7生成一个爬行者。");
            lore.add("   §7放置一个速爆TNT并且造成§a" + this.getDamage(level));
            lore.add("   §7点伤害但不破坏方块。");
            return lore;
        } else {
            lore.add(" §8▪ §7被击杀时,有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7生成一个爬行者。");
            lore.add("   §7放置一个速爆TNT并且造成§8" + this.getDamage(level - 1) + " ➜ §a" + this.getDamage(level));
            lore.add("   §7点伤害但不破坏方块。");
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
