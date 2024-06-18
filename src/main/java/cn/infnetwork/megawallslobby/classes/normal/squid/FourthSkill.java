package cn.infnetwork.megawallslobby.classes.normal.squid;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("海之眷顾", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.15D;
            case 2:
                return 0.2D;
            case 3:
                return 0.25D;
            default:
                return 0.15D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7有§a" + StringUtils.percent(this.getAttribute(level)) + "§7的几率在箱子中找到");
            lore.add("    §71:00伤害吸收II药水。");
            return lore;
        } else {
            lore.add(" §8▪ §7有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("    §a" + StringUtils.percent(this.getAttribute(level)) + "§7的几率在箱子中找到");
            lore.add("    §71:00伤害吸收II药水。");
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
