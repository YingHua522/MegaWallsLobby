package cn.infnetwork.megawallslobby.classes.mythic.phoenix;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("灵魂契约", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.05D;
            case 2:
                return 0.1D;
            case 3:
                return 0.15D;
            default:
                return 0.05D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7用剑右键点击一名队友与之订立契约");
            lore.add(" §8▪ §7契约将在你和契约对象相距16格范围内时生效");
            lore.add(" §8▪ §7契约生效时,每3.75秒你和队友均恢复1点生命值");
            lore.add(" §8▪ §7战墙倒塌后,你的队友同时每秒恢复其每次攻击获得能量最高值的§a" + StringUtils.percent(this.getAttribute(level)));
            lore.add(" §8▪ §7其他来源的生命恢复效果将会暂停契约生命恢复");
            return lore;
        } else {
            lore.add(" §8▪ §7战墙倒塌后,你的队友同时每秒恢复其每次攻击获得能量最高值的§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜");
            lore.add("   §a" + StringUtils.percent(this.getAttribute(level)));
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
