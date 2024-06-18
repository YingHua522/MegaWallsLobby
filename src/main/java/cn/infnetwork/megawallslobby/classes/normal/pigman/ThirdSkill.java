package cn.infnetwork.megawallslobby.classes.normal.pigman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("守护", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 4.0D;
            case 2:
                return 5.0D;
            case 3:
                return 6.0D;
            default:
                return 4.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7生命值低于7心时,会获得");
            lore.add("   §a" + (int) this.getAttribute(level) + "§7秒的抗性提升II效果");
            lore.add(" ");
            lore.add("§7冷却时间：§a30秒");
            return lore;
        } else {
            lore.add(" §8▪ §7生命值低于7心时,会获得");
            lore.add("   §8" + (int) this.getAttribute(level - 1) + " ➜ §a" + (int) this.getAttribute(level) + "§7秒的抗性提升II效果");
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
