package cn.infnetwork.megawallslobby.classes.normal.creeper;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("意志", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 6.0D;
            case 2:
                return 8.0D;
            case 3:
                return 10.0D;
            default:
                return 6.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你的血量低于20时,你获得");
            lore.add("   §7速度II和生命恢复I效果,持续§a" + this.getAttribute(level) + "§7秒。");
            lore.add(" ");
            lore.add("§7冷却时间:§a20秒");
            return lore;
        } else {
            lore.add(" §8▪ §7当你的血量低于20时,你获得");
            lore.add("   §7速度II和生命恢复I效果,持续§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒。");
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
