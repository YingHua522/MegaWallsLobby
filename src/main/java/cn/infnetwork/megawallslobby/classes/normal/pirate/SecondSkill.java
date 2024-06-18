package cn.infnetwork.megawallslobby.classes.normal.pirate;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("愤怒的小鸟", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 50.0D;
            case 2:
                return 40.0D;
            case 3:
                return 30.0D;
            default:
                return 50.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7每§a" + this.getAttribute(level) + "§7秒召唤一只鹦鹉。当你受到");
            lore.add("   §7攻击时,你的鹦鹉会在敌人处爆");
            lore.add("   §7炸并造成2点真实伤害。");
            return lore;
        } else {
            lore.add(" §8▪ §7每§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒召唤一只鹦鹉。当你受到");
            lore.add("   §7攻击时,你的鹦鹉会在敌人处爆");
            lore.add("   §7炸并造成2点真实伤害。");
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
