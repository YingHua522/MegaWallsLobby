package cn.infnetwork.megawallslobby.classes.mythic.werewolf;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("吞噬", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.8D;
            case 2:
                return 0.9D;
            case 3:
                return 1.0D;
            default:
                return 0.8D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7食用牛排时,有§a" + StringUtils.percent(this.getAttribute(level)) + "§7几率获得");
            lore.add("   §75秒的生命恢复I效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7食用牛排时,有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level - 1)) + "§7几率获得");
            lore.add("   §75秒的生命恢复I效果。");
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
