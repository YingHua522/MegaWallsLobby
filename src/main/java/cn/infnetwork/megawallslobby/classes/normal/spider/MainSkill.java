package cn.infnetwork.megawallslobby.classes.normal.spider;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("跳跃", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 3.0D;
            case 2:
                return 3.5D;
            case 3:
                return 4.0D;
            case 4:
                return 4.5D;
            case 5:
                return 5.0D;
            default:
                return 3.0D;
        }
    }

    public int getHits(int level) {
        switch (level) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 3;
            case 5:
                return 4;
            default:
                return 1;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7向前跳跃至空中,获得5秒的生命");
            lore.add("   §7恢复I效果。落地时,周围敌人受");
            lore.add("   §7到§a" + this.getAttribute(level) + "§7点伤害和持续4秒的缓慢I效果,");
            lore.add("   §7你则获得§a" + this.getHits(level) + "§7次毒液之击的机会。");
            return lore;
        } else {
            lore.add(" §8▪ §7向前跳跃至空中,获得5秒的生命");
            lore.add("   §7恢复I效果。落地时,周围敌人受");
            lore.add("   §7到§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害和持续4秒的缓慢I效果,");
            lore.add("   §7你则获得§8" + this.getHits(level - 1) + (this.getHits(level - 1) == this.getHits(level) ? "" : " ➜ §a" + this.getHits(level)) + "§7次毒液之击的机会。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkillLevel();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkillLevel();
    }
}
