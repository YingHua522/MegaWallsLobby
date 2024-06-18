package cn.infnetwork.megawallslobby.classes.normal.pigman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("勇气", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.08D;
            case 2:
                return 0.09D;
            case 3:
                return 0.1D;
            default:
                return 0.08D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7攻击敌人时,有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率给予周围");
            lore.add("   §7血量少于20的玩家抗性提升I效果");
            lore.add("   §7和生命恢复I效果,持续8秒。无论你的");
            lore.add("   §7血量高低,同时给予你5秒生命恢复I效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7攻击敌人时,有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率给予周围");
            lore.add("   §7血量少于20的玩家抗性提升I效果");
            lore.add("   §7和生命恢复I效果,持续8秒。无论你的");
            lore.add("   §7血量高低,同时给予你5秒生命恢复I效果。");
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
