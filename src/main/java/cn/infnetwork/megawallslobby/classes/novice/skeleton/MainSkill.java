package cn.infnetwork.megawallslobby.classes.novice.skeleton;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("爆炸箭矢", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.1D;
            case 2:
                return 0.12D;
            case 3:
                return 0.14D;
            case 4:
                return 0.16D;
            case 5:
                return 0.18D;
            default:
                return 0.1D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7发射一支爆炸箭,");
            lore.add("   §7造成敌人剩余血量§a" + StringUtils.percent(this.getAttribute(level)) + "§7的伤害,");
            lore.add("   §7并击退周围敌人。最少造成2点伤害。");
            return lore;
        } else {
            lore.add(" §8▪ §7发射一支爆炸箭,");
            lore.add("   §7造成敌人剩余血量§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7的伤害,");
            lore.add("   §7并击退周围敌人。最少造成2点伤害。");
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
