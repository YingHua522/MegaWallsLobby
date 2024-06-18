package cn.infnetwork.megawallslobby.classes.normal.hunter;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("黄金眼镜", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.25D;
            case 2:
                return 0.5D;
            case 3:
                return 0.75D;
            default:
                return 0.25D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7获得永久夜视效果,并有§a" + StringUtils.percent(this.getAttribute(level)) + "§7的");
            lore.add("    §7几率在箱子中获得一个金苹果。");
            return lore;
        } else {
            lore.add(" §8▪ §7获得永久夜视效果,并有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7的");
            lore.add("    §7几率在箱子中获得一个金苹果。");
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
