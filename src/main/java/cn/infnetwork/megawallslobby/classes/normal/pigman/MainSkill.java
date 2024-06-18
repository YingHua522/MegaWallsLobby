package cn.infnetwork.megawallslobby.classes.normal.pigman;

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
                return 4.0D;
            case 2:
                return 5.0D;
            case 3:
                return 6.0D;
            case 4:
                return 7.0D;
            case 5:
                return 8.0D;
            default:
                return 4.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7获得5秒抗性提升I效果。");
            lore.add("   §7周围的玩家将受到");
            lore.add("   §7火焰旋涡的影响,持续5秒");
            lore.add("   §7造成最多§a" + this.getAttribute(level) + "§7点伤害");
            return lore;
        } else {
            lore.add(" §8▪ §7获得5秒抗性提升I效果。");
            lore.add("   §7周围的玩家将受到");
            lore.add("   §7火焰旋涡的影响,持续5秒");
            lore.add("   §7造成最多§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害");
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
