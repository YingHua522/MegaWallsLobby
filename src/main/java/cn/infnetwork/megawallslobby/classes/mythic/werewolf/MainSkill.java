package cn.infnetwork.megawallslobby.classes.mythic.werewolf;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("狼人变身", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 3.2D;
            case 2:
                return 4.4D;
            case 3:
                return 5.6D;
            case 4:
                return 6.8D;
            case 5:
                return 8.0D;
            default:
                return 3.2D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7获得持续§a" + this.getAttribute(level) + "§7秒的速度 II 效果。");
            lore.add("   §7在这期间,你会恢复你造成伤害的30%");
            lore.add("   §7并且攻击敌人时造成2点真实伤害");
            return lore;
        } else {
            lore.add(" §8▪ §7获得持续§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒的速度 II 效果。");
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
