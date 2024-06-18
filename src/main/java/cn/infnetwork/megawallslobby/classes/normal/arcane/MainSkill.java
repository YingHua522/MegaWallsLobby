package cn.infnetwork.megawallslobby.classes.normal.arcane;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import org.bukkit.Material;

import java.util.*;

public class MainSkill extends Skill {
    private static final Set<Material> set = new HashSet();

    static {
        Material[] var0 = Material.values();
        int var1 = var0.length;

        set.addAll(Arrays.asList(var0).subList(0, var1));

    }

    public MainSkill(Classes classes) {
        super("奥术激光", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 1.0D;
            case 2:
                return 1.25D;
            case 3:
                return 1.5D;
            case 4:
                return 1.75D;
            case 5:
                return 2.0D;
            default:
                return 1.0D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7发射一束激光,造成§a" + this.getAttribute(level) + "§7点伤害");
            lore.add("   §7也可以使用此技能进行挖掘。");
            lore.add(" ");
            lore.add("§7冷却时间:§a1秒");
            return lore;
        } else {
            lore.add(" §8▪ §7发射一束激光,造成§8" + this.getAttribute(level - 1) + " ➜ §a" + this.getAttribute(level) + "§7点伤害");
            lore.add("   §7也可以使用此技能进行挖掘。");
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
