package cn.infnetwork.megawallslobby.classes.normal.hunter;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("自然之力", classes);
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
            lore.add(" §8▪ §7每§a" + this.getAttribute(level) + "§7秒获得一个随机增益效果。");
            lore.add("   §7可能是持续11秒的速度I,6秒的");
            lore.add("   §7抗性提升I,15秒的急迫I,6秒的");
            lore.add("   §7力量I,10秒的生命恢复II或者6秒");
            lore.add("   §7的速度II。高墙倒下后将不再获得");
            lore.add("   §7急迫I效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7每§8" + this.getAttribute(level - 1) + " ➜");
            lore.add("   §a" + this.getAttribute(level) + "§7秒获得一个随机增益效果。");
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
