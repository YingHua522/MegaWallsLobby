package cn.infnetwork.megawallslobby.classes.normal.creeper;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("引爆", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 6.0D;
            case 2:
                return 7.0D;
            case 3:
                return 8.0D;
            case 4:
                return 9.0D;
            case 5:
                return 10.0D;
            default:
                return 6.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7引发一场爆炸,");
            lore.add("   §7对周围敌人造成至多§a" + this.getAttribute(level) + "§7点伤害");
            lore.add("   §7不过,需要3秒才能引爆。");
            return lore;
        } else {
            lore.add("   §7对周围敌人造成至多§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害");
            lore.add("   §7不过,需要3秒才能引爆。");
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
