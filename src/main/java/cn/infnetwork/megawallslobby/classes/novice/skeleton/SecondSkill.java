package cn.infnetwork.megawallslobby.classes.novice.skeleton;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("箭矢回收", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.3D;
            case 2:
                return 0.6D;
            case 3:
                return 0.9D;
            default:
                return 0.6D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7箭击中敌人时,有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7获得两只箭并恢复饱食度。");
            return lore;
        } else {
            lore.add(" §8▪ §7箭击中敌人时,有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7几率");
            lore.add("   §7获得两支箭并恢复饱食度。");
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
