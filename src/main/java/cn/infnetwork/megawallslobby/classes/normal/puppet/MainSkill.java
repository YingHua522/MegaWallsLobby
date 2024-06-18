package cn.infnetwork.megawallslobby.classes.normal.puppet;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("钢铁之击", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 2.6D;
            case 2:
                return 3.2D;
            case 3:
                return 3.8D;
            case 4:
                return 4.4D;
            case 5:
                return 5.0D;
            default:
                return 2.6D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7在4.5块方块半径内");
            lore.add("   §7的区域造成§a" + this.getAttribute(level) + "§7点伤害。");
            lore.add(" ");
            lore.add("§7冷却时间:§a2秒");
            return lore;
        } else {
            lore.add(" §8▪ §7在4.5块方块半径内");
            lore.add("   §7的区域造成§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害。");
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
