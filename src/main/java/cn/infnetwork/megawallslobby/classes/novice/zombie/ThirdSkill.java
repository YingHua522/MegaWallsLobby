package cn.infnetwork.megawallslobby.classes.novice.zombie;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

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
                return 0.08D;
            case 2:
                return 0.16D;
            case 3:
                return 0.24D;
            default:
                return 0.08D;
        }
    }

    public int getSeconds(int level) {
        switch (level) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            default:
                return 3;
        }
    }

    public int getCooldownSeconds(int level) {
        switch (level) {
            case 1:
                return 32;
            case 2:
                return 25;
            case 3:
                return 18;
            default:
                return 32;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7被箭矢命中时,获得§a" + StringUtils.percent(this.getAttribute(level)) + "§7近战伤害加成");
            lore.add("   §7以及速度II效果,持续§a" + this.getSeconds(level) + "§7秒。");
            lore.add(" ");
            lore.add("§7冷却时间：§a32秒");
            return lore;
        } else {
            lore.add(" §8▪ §7被箭矢命中时,获得§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7近战伤害加成");
            lore.add("   §7以及速度II效果,持续§8" + this.getSeconds(level - 1) + " ➜ §a" + this.getSeconds(level) + "§7秒。");
            lore.add("§7冷却时间：§8" + this.getCooldownSeconds(level - 1) + "秒 ➜ §a" + this.getCooldownSeconds(level) + "秒");
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
