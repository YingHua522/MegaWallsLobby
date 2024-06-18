package cn.infnetwork.megawallslobby.classes.novice.him;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("飓风", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 5.0D;
            case 2:
                return 4.0D;
            case 3:
                return 3.0D;
            default:
                return 5.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7每§a" + this.getAttribute(level) + "§7次攻击,获得");
            lore.add("   §7速度 II 和生命恢复 II 持续3秒");
            return lore;
        } else {
            lore.add(" §8▪ §7每§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7次攻击,获得");
            lore.add("   §7速度 II 和生命恢复 II 持续3秒");
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
