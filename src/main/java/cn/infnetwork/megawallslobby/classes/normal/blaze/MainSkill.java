package cn.infnetwork.megawallslobby.classes.normal.blaze;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;

import java.util.ArrayList;
import java.util.List;

public class MainSkill extends Skill {
    public MainSkill(Classes classes) {
        super("献祭爆裂", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 1.33D;
            case 2:
                return 1.67D;
            case 3:
                return 2.0D;
            case 4:
                return 2.33D;
            case 5:
                return 2.67D;
            default:
                return 1.33D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7发射3颗火球,每颗");
            lore.add("   §7爆炸造成§a" + this.getAttribute(level) + "§7点伤害。");
            return lore;
        } else {
            lore.add(" §8▪ §7发射3颗火球,每颗");
            lore.add("   §7爆炸造成§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害。");
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
