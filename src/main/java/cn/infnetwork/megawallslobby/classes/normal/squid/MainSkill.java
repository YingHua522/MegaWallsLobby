package cn.infnetwork.megawallslobby.classes.normal.squid;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("鱿鱼飞溅", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.3667D;
            case 2:
                return 0.45D;
            case 3:
                return 0.5333D;
            case 4:
                return 0.6167D;
            case 5:
                return 0.7D;
            default:
                return 0.3667D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7将敌人传送至你的位置并且");
            lore.add("   §7对3格以内的所有敌人造成3点伤害。");
            lore.add("   §7你会恢复你造成的伤害的§a" + StringUtils.percent(this.getAttribute(level)) + "§7。");
            lore.add("   §7最多恢复7点生命。");
            lore.add(" ");
            lore.add("§7冷却时间:§a2秒");
            return lore;
        } else {
            lore.add(" §8▪ §7将敌人传送至你的位置并且");
            lore.add("   §7对3格以内的所有敌人造成3点伤害。");
            lore.add("   §7你会恢复你造成的伤害的§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)) + "§7。");
            lore.add("   §7最多恢复7点生命。");
            lore.add(" ");
            lore.add("§7冷却时间:§a2秒");
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
