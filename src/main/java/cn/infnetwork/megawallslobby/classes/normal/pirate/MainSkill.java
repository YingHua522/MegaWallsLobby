package cn.infnetwork.megawallslobby.classes.normal.pirate;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("加农炮火", classes);
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
            lore.add(" §8▪ §7发射炮弹,击中时造成§a" + this.getAttribute(level) + "§7的伤害,");
            lore.add("   §7在爆炸前对每个玩家造成一半伤害,");
            lore.add("   §7并击退附近的玩家。");
            return lore;
        } else {
            lore.add(" §8▪ §7发射炮弹,击中时造成§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7的伤害,");
            lore.add("   §7在爆炸前对每个玩家造成一半伤害,");
            lore.add("   §7并击退附近的玩家。");
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
