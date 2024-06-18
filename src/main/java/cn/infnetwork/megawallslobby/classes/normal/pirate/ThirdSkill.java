package cn.infnetwork.megawallslobby.classes.normal.pirate;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("海上漂", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 16.0D;
            case 2:
                return 20.0D;
            case 3:
                return 24.0D;
            default:
                return 16.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当生命降到§a" + this.getAttribute(level) + "§7时,获得持续");
            lore.add("   §715秒的速度II效果。");
            lore.add(" ");
            lore.add("§7冷却时间：§a30秒");
            return lore;
        } else {
            lore.add(" §8▪ §7当生命降到§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7时,获得持续");
            lore.add("   §715秒的速度II效果。");
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
