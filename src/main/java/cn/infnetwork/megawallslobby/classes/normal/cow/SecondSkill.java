package cn.infnetwork.megawallslobby.classes.normal.cow;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("奶桶屏障", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.25D;
            case 2:
                return 0.375D;
            case 3:
                return 0.5D;
            default:
                return 0.25D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你血量低于20的时候,");
            lore.add("   §7你头顶会不断掉出奶桶,持续20秒");
            lore.add("   §7接下来4次任何来源的伤害都将被减少§a" + StringUtils.percent(this.getAttribute(level)));
            lore.add("   §7每次减伤你额外恢复2血量。");
            return lore;
        } else {
            lore.add(" §8▪ §7当你血量低于20的时候,");
            lore.add("   §7你头顶会不断掉出奶桶,持续20秒");
            lore.add("   §7接下来4次任何来源的伤害都将被减少§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)));
            lore.add("   §7每次减伤你额外恢复2血量。");
            lore.add(" ");
            lore.add("§7冷却时间:§a40秒");
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
