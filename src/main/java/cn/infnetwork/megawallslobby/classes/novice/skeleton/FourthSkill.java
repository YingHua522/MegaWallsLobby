package cn.infnetwork.megawallslobby.classes.novice.skeleton;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("效率", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.3333D;
            case 2:
                return 0.6667D;
            case 3:
                return 1.0D;
            default:
                return 0.3333D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7在挖矿或伐木时,");
            lore.add("    §7有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率获得三倍掉落。");
            return lore;
        } else {
            lore.add(" §8▪ §7在挖矿或伐木时,");
            lore.add("    §7有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("    §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率获得三倍掉落。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill4Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill4Level();
    }
}
