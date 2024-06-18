package cn.infnetwork.megawallslobby.classes.novice.zombie;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("治愈之环", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 4.2D;
            case 2:
                return 4.8D;
            case 3:
                return 5.4D;
            case 4:
                return 6.0D;
            case 5:
                return 6.6D;
            default:
                return 4.2D;
        }
    }

    public double getMateAttribute(int level) {
        switch (level) {
            case 1:
                return 3.5D;
            case 2:
                return 3.9D;
            case 3:
                return 4.3D;
            case 4:
                return 4.7D;
            case 5:
                return 5.1D;
            default:
                return 3.55D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7恢复你自己 §a" + this.getAttribute(level) + "血量");
            lore.add("   §7和你附近的队友 §a" + this.getMateAttribute(level) + "血量");
            return lore;
        } else {
            lore.add(" §8▪ §7恢复你自己 §8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "血量");
            lore.add("   §7和你附近的队友 §8" + this.getMateAttribute(level - 1) + " ➜ §a" + this.getMateAttribute(level) + "血量");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkillLevel();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkillLevel();
    }
}
