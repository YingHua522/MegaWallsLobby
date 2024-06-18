package cn.infnetwork.megawallslobby.classes.mythic.werewolf;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("嗜血", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 4.0D;
            case 2:
                return 6.0D;
            case 3:
                return 8.0D;
            default:
                return 4.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7连续3次近战攻击或箭矢命中,");
            lore.add("   §7而自身未受到伤害时,将获得持续");
            lore.add("   §a" + this.getAttribute(level) + "§7秒的速度I和抗性提升II效果。");
            return lore;
        } else {
            lore.add(" §8▪ §7连续3次近战攻击或箭矢命中,");
            lore.add("   §7而自身未受到伤害时,将获得持续");
            lore.add("   §8" + this.getAttribute(level - 1) + " ➜");
            lore.add("   §a" + this.getAttribute(level) + "§7秒的速度I和抗性提升II效果。");
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
