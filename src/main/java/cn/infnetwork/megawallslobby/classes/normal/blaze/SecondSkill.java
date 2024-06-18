package cn.infnetwork.megawallslobby.classes.normal.blaze;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("烈焰人召唤术", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
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

    public int getAmount(int level) {
        switch (level) {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 1;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7击杀敌人时有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7生成§a" + this.getAmount(level) + "个烈焰人。");
            return lore;
        } else {
            lore.add(" §8▪ §7击杀敌人时有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7生成§8" + (this.getAmount(level - 1) == this.getAmount(level) ? this.getAmount(level) : this.getAmount(level - 1) + " ➜ §a" + this.getAmount(level)) + "§7个烈焰人。");
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
