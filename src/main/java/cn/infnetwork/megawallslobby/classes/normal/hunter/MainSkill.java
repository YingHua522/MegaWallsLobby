package cn.infnetwork.megawallslobby.classes.normal.hunter;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("鹰眼", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 7.6D;
            case 2:
                return 9.2D;
            case 3:
                return 10.8D;
            case 4:
                return 12.4D;
            case 5:
                return 14.0D;
            default:
                return 7.6D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7为拉满的弓箭附加追踪效果,持续§a" + this.getAttribute(level) + "§7秒。");
            lore.add("   §7每次命中恢复0.5血量,但不会增加能量。");
            return lore;
        } else {
            lore.add(" §8▪ §7为拉满的弓箭附加追踪效果,持续§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒。");
            lore.add("   §7每次命中恢复0.5血量,但不会增加能量。");
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
