package cn.infnetwork.megawallslobby.classes.normal.shaman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("狼群", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 4.0D;
            case 2:
                return 8.0D;
            case 3:
                return 12.0D;
            default:
                return 4.0D;
        }
    }

    public int getHits(int level) {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 8;
            case 3:
                return 6;
            default:
                return 10;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        lore.add(" §8▪ §7被攻击时,有10%的几率召唤");
        lore.add("   §7一只保护你§a" + this.getAttribute(level) + "§7秒的狼。");
        return lore;
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill3Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill3Level();
    }
}
