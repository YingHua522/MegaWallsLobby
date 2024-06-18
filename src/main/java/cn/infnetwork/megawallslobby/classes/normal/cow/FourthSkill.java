package cn.infnetwork.megawallslobby.classes.normal.cow;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public FourthSkill(Classes classes) {
        super("超级巴氏杀菌", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.01D;
            case 2:
                return 0.02D;
            case 3:
                return 0.03D;
            default:
                return 0.01D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7石头有§a" + StringUtils.percent(this.getAttribute(level)) + "§7掉落牛奶桶。");
            lore.add("   §7饮用牛奶桶可获得抗性提升I和生命恢复I,");
            lore.add("   §7持续5秒。牛奶桶可被丢出。");
            lore.add("   §7对于非奶牛职业的玩家,生命恢复加倍。");
            return lore;
        } else {
            lore.add(" §8▪ §7石头有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7掉落牛奶桶。");
            lore.add("   §7饮用牛奶桶可获得抗性提升I和生命恢复I,");
            lore.add("   §7持续5秒。牛奶桶可被丢出。");
            lore.add("   §7对于非奶牛职业的玩家,生命恢复加倍。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill4Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill4Level();
    }
}
