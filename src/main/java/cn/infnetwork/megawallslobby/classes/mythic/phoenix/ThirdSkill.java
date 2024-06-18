package cn.infnetwork.megawallslobby.classes.mythic.phoenix;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThirdSkill extends Skill {
    public ThirdSkill(Classes classes) {
        super("凤凰涅槃", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.6D;
            case 2:
                return 0.8D;
            case 3:
                return 1.0D;
            default:
                return 0.6D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7受到致命伤害时,将会暂时石化并同时恢复§a" + StringUtils.percent(this.getAttribute(level)) + "§7的生命值");
            lore.add(" §8▪ §7在涅槃结束时你获得虚弱IV、速度II和抗性提升II,持续10秒");
            lore.add(" §8▪ §7每局游戏你只能涅槃一次");
            lore.add(" §8▪ §7该效果在凋零死亡后生效");
            lore.add("   §7凤凰涅槃对你的契约队友也生效一次,恢复其§a" + StringUtils.percent(this.getAttribute(level) / 2.0D) + "§7的生命值");
            return lore;
        } else {
            lore.add(" §8▪ §7受到致命伤害时,将会暂时石化并同时恢复§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7的生命值");
            lore.add("   §7凤凰涅槃对你的契约队友也生效一次,恢复其§8" + StringUtils.percent(this.getAttribute(level - 1) / 2.0D) + " ➜ §a" + StringUtils.percent(this.getAttribute(level) / 2.0D) + "§7的生命值");
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
