package cn.infnetwork.megawallslobby.classes.novice.enderman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("灵魂爆发", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 2.66D;
            case 2:
                return 4.33D;
            case 3:
                return 6.55D;
            default:
                return 2.66D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你能量达到100%时,");
            lore.add("   §7获得§a" + this.getAttribute(level) + "§7秒生命恢复I效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7当你能量达到100%时,");
            lore.add("   §7获得§8" + this.getAttribute(level - 1) + " ➜");
            lore.add("   §a" + this.getAttribute(level) + "§7秒生命恢复I效果。");
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
