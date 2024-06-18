package cn.infnetwork.megawallslobby.classes.normal.spider;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("打滑者", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 3.0D;
            case 2:
                return 4.0D;
            case 3:
                return 5.0D;
            default:
                return 3.0D;
        }
    }

    public int getEnergy(int level) {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 15;
            case 3:
                return 20;
            default:
                return 10;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你在3秒内消耗4次毒液之击时,");
            lore.add("   §7你将获得持续§a" + this.getAttribute(level) + "§7秒的速度I效果");
            lore.add("   §7和§a" + this.getEnergy(level) + "§7能量。");
            return lore;
        } else {
            lore.add(" §8▪ §7当你在3秒内消耗4次毒液之击时,");
            lore.add("   §7你将获得持续§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒的速度I效果");
            lore.add("   §7和§8" + this.getEnergy(level - 1) + " ➜ §a" + this.getEnergy(level) + "§7能量。");
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
