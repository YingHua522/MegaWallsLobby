package cn.infnetwork.megawallslobby.classes.normal.puppet;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("铜皮铁骨", classes);
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
                return 6;
            case 3:
                return 9;
            default:
                return 3;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7被箭矢击中时,会获得持续§a" + this.getSeconds(level) + "§7秒的");
            lore.add("   §7抗性提升I效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7被箭矢击中时,会获得持续§8" + this.getSeconds(level - 1) + " ➜ §a" + this.getSeconds(level) + "§7秒的");
            lore.add("   §7抗性提升I效果。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill3Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill3Level();
    }
}
