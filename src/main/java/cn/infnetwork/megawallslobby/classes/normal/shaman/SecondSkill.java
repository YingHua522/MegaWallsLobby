package cn.infnetwork.megawallslobby.classes.normal.shaman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("英勇", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        return 0.0D;
    }

    public int getSeconds(int level) {
        switch (level) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            default:
                return 3;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        lore.add(" §8▪ §7攻击一位玩家时,有17%的几率获得");
        lore.add("   §a" + this.getSeconds(level) + "§7秒的速度II效果并给敌方虚弱I效果。");
        return lore;
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill2Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill2Level();
    }
}
