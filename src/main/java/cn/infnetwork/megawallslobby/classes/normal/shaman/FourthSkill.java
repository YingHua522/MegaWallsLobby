package cn.infnetwork.megawallslobby.classes.normal.shaman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("灵力开采", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.2D;
            case 2:
                return 0.4D;
            case 3:
                return 0.6D;
            default:
                return 0.2D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        lore.add(" §8▪ §7挖铁矿时有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率。");
        lore.add("   §7掉落一根原木和一块煤炭。");
        return lore;
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill4Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill4Level();
    }
}
