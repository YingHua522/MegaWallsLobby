package cn.infnetwork.megawallslobby.classes.normal.puppet;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("钢铁之心", classes);
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
                return 4;
            case 2:
                return 7;
            case 3:
                return 10;
            default:
                return 4;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7击杀玩家后,获得持续§a" + this.getSeconds(level) + "§7秒的");
            lore.add("   §7吸收II效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7击杀玩家后,获得持续§8" + this.getSeconds(level - 1) + " ➜ §a" + this.getSeconds(level) + "§7秒的");
            lore.add("   §7吸收II效果。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill2Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill2Level();
    }
}
