package cn.infnetwork.megawallslobby.classes.normal.dreadlord;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("灵魂吸嗜", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.55D;
            case 2:
                return 0.65D;
            case 3:
                return 0.75D;
            default:
                return 0.55D;
        }
    }

    public double getSeconds(int level) {
        switch (level) {
            case 1:
                return 1.0D;
            case 2:
                return 2.5D;
            case 3:
                return 5.0D;
            default:
                return 1.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7击杀敌人时,获得§a" + StringUtils.percent(this.getAttribute(level)) + "§7伤害加成");
            lore.add("   §7和生命恢复I效果,持续§a" + this.getSeconds(level) + "§7秒。");
            return lore;
        } else {
            lore.add(" §8▪ §7击杀敌人时,获得§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7伤害加成");
            lore.add("   §7和生命恢复I效果,持续§8" + this.getSeconds(level - 1) + " ➜ §a" + this.getSeconds(level) + "§7秒。");
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
