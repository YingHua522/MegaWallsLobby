package cn.infnetwork.megawallslobby.classes.novice.zombie;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("坚韧", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.125D;
            case 2:
                return 0.25D;
            case 3:
                return 0.375D;
            default:
                return 0.125D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7被近战命中时,有§a" + StringUtils.percent(this.getAttribute(level)) + "§7的几率");
            lore.add("   §7获得抗性提升I效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7被近战命中时,有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7的几率");
            lore.add("   §7获得抗性提升I效果。");
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
