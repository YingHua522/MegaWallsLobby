package cn.infnetwork.megawallslobby.classes.novice.him;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class SecondSkill extends Skill {
    public SecondSkill(Classes classes) {
        super("力量", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 4.0D;
            case 2:
                return 5.0D;
            case 3:
                return 6.0D;
            default:
                return 4.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7击杀一名敌人后,获得85%的近战");
            lore.add("   §7伤害加成,持续§a" + this.getAttribute(level) + "§7秒。");
            return lore;
        } else {
            lore.add(" §8▪ §7击杀一名敌人后,获得85%的近战");
            lore.add("   §7伤害加成,持续§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7秒。");
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
