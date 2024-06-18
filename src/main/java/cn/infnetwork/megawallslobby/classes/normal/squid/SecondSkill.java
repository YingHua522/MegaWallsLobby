package cn.infnetwork.megawallslobby.classes.normal.squid;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("喷墨", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 2.0D;
            case 2:
                return 3.0D;
            case 3:
                return 4.0D;
            default:
                return 2.0D;
        }
    }

    public double getSeconds(int level) {
        switch (level) {
            case 1:
                return 0.8D;
            case 2:
                return 1.6D;
            case 3:
                return 2.4D;
            default:
                return 0.8D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你喝完药水的时候,");
            lore.add("   §7令§a" + this.getAttribute(level) + "§7格范围内的敌人失明§a" + this.getSeconds(level) + "§7秒。");
            return lore;
        } else {
            lore.add(" §8▪ §7当你喝完药水的时候,");
            lore.add("   §7令§8" + this.getAttribute(level - 1) + " ➜");
            lore.add("   §a" + this.getAttribute(level) + "§7格范围内的敌人失明§8" + this.getSeconds(level - 1) + " ➜ §a" + this.getSeconds(level) + "§7秒。");
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
