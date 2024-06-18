package cn.infnetwork.megawallslobby.classes.normal.cow;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("抚慰之哞", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 1.7D;
            case 2:
                return 1.9D;
            case 3:
                return 2.1D;
            case 4:
                return 2.3D;
            case 5:
                return 2.5D;
            default:
                return 1.7D;
        }
    }

    public int getRegenLevel(int level) {
        switch (level) {
            case 1:
            case 2:
                return 1;
            case 3:
            case 4:
            case 5:
                return 2;
            default:
                return 1;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7哞,");
            lore.add("   §7自身获得抗性提升I和生命");
            lore.add("   §7恢复I效果,周围的队友获得");
            lore.add("   §7持续§a" + this.getAttribute(level) + "§7秒的生命恢复§a" + StringUtils.level(this.getRegenLevel(level)) + "§7效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7哞,");
            lore.add("   §7自身获得抗性提升I和生命");
            lore.add("   §7恢复I效果,周围的队友获得");
            lore.add("   §7持续§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒的生命恢复§8" + StringUtils.level(this.getRegenLevel(level - 1)) + " ➜ §a" + StringUtils.level(this.getRegenLevel(level)) + "§7效果。");
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
