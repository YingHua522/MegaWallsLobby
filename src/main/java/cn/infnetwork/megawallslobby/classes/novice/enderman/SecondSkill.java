package cn.infnetwork.megawallslobby.classes.novice.enderman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("末影之心", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.13D;
            case 2:
                return 0.26D;
            case 3:
                return 0.39D;
            default:
                return 0.13D;
        }
    }

    public double getHeal(int level) {
        switch (level) {
            case 1:
                return 1.0D;
            case 2:
                return 2.0D;
            case 3:
                return 3.0D;
            default:
                return 1.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率在死后不会掉落物品。");
            lore.add("   §7当你的凋零死后,每次击杀获得§a" + this.getHeal(level) + "§7点生命。");
            return lore;
        } else {
            lore.add(" §8▪ §7有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率在死后不会掉落物品。");
            lore.add("   §7当你的凋零死后,每次击杀获得§8" + this.getHeal(level - 1) + " ➜");
            lore.add("   §a" + this.getHeal(level) + "§7点生命。");
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
