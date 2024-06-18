package cn.infnetwork.megawallslobby.classes.normal.arcane;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("奥术采矿", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 16.0D;
            case 2:
                return 18.0D;
            case 3:
                return 20.0D;
            default:
                return 16.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7挖掘矿石会给你§a" + this.getAttribute(level) + "§7能量。");
            return lore;
        } else {
            lore.add(" §8▪ §7挖掘矿石会给你§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7能量。");
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
