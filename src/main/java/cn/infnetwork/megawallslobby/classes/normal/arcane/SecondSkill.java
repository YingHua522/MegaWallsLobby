package cn.infnetwork.megawallslobby.classes.normal.arcane;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("奥术风暴", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 3.0D;
            case 2:
                return 4.0D;
            case 3:
                return 5.0D;
            default:
                return 3.0D;
        }
    }

    public int getSpeed(int level) {
        switch (level) {
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 2;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7击杀玩家时,会获得§a" + this.getAttribute(level) + "§7秒的生命恢复II");
            lore.add("   §7和6秒的速度§a" + StringUtils.level(this.getSpeed(level)) + "§7效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7击杀玩家时,会获得§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒的生命恢复II");
            lore.add("   §7和6秒的速度§8" + (this.getSpeed(level - 1) == this.getSpeed(level) ? StringUtils.level(this.getSpeed(level)) : StringUtils.level(this.getSpeed(level - 1)) + " ➜ §a" + StringUtils.level(this.getSpeed(level))) + "§7效果。");
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
