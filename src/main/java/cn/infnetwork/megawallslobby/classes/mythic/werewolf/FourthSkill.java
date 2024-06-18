package cn.infnetwork.megawallslobby.classes.mythic.werewolf;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("食肉", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.6D;
            case 2:
                return 0.8D;
            case 3:
                return 1.0D;
            default:
                return 0.6D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7击杀敌人有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率掉落1个牛排,");
            lore.add("    §7最终击杀可获得4个牛排。");
            return lore;
        } else {
            lore.add(" §8▪ §7击杀敌人有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率掉落1个牛排,");
            lore.add("    §7最终击杀可获得4个牛排。");
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
