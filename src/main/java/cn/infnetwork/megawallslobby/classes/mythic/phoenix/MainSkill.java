package cn.infnetwork.megawallslobby.classes.mythic.phoenix;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("阳炎射线", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 2.2D;
            case 2:
                return 2.4D;
            case 3:
                return 2.6D;
            case 4:
                return 2.8D;
            case 5:
                return 3.0D;
            default:
                return 2.2D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7左键你的弓来发射一道阳炎射线");
            lore.add("   §7在阳炎射线落点附近的队友将恢复§a" + this.getAttribute(level) + "§7生命值并获得速度I,持续10秒");
            lore.add("   §7消耗28能量");
            lore.add("   §7每次攻击获得能量(近战):6");
            lore.add("   §7每次攻击获得能量(弓箭):12");
            return lore;
        } else {
            lore.add(" §8▪ §7在阳炎射线落点附近的队友将恢复§8" + this.getAttribute(level - 1) + " ➜");
            lore.add("   §a" + this.getAttribute(level) + "§7生命值并获得速度I,持续10秒");
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
