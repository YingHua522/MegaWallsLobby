package cn.infnetwork.megawallslobby.classes.normal.shaman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("龙卷风", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 1.0D;
            case 2:
                return 1.12D;
            case 3:
                return 1.25D;
            case 4:
                return 1.38D;
            case 5:
                return 1.5D;
            default:
                return 1.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        lore.add(" §8▪ §7生成一个毁灭性的龙卷风,");
        lore.add("   §7每秒对沿途玩家造成§a" + this.getAttribute(level) + "§7点伤害。");
        return lore;
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkillLevel();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkillLevel();
    }
}
