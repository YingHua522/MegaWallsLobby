package cn.infnetwork.megawallslobby.classes.novice.enderman;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.Skill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.StringUtils;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainSkill extends Skill {
    private static final Set<Material> set = new HashSet();

    static {
        Material[] var0 = Material.values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            Material material = var0[var2];
            set.add(material);
        }

    }

    public MainSkill(Classes classes) {
        super("瞬移", classes);
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 13.0D;
            case 2:
                return 16.0D;
            case 3:
                return 19.0D;
            case 4:
                return 22.0D;
            case 5:
                return 25.0D;
            default:
                return 13.0D;
        }
    }

    public int getSpeed(int level) {
        switch (level) {
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            default:
                return 0;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7瞬移到在§a" + this.getAttribute(level) + "§7格以内的指定玩家,");
            lore.add("   §7并获得5秒的速度§a" + StringUtils.level(this.getSpeed(level)) + "§7效果。");
            lore.add("   §7在激活速度" + StringUtils.level(this.getSpeed(level)) + "效果时,每次攻击");
            lore.add("   §7获得的能量减半");
            lore.add(" ");
            lore.add("§7冷却时间:§a5秒");
            return lore;
        } else {
            lore.add(" §8▪ §7瞬移到在§8" + this.getAttribute(level - 1) + " ➜");
            lore.add("   §a" + this.getAttribute(level) + "§7格以内的指定玩家,");
            if (level % 2 == 0) {
                lore.add("   §7并获得5秒的速度§8" + StringUtils.level(this.getSpeed(level)) + "§7效果。");
            } else {
                lore.add("   §7并获得5秒的速度§8" + StringUtils.level(this.getSpeed(level - 1)) + " ➜");
                lore.add("   §a" + StringUtils.level(this.getSpeed(level)) + "效果。");
            }

            lore.add("   §7在激活速度" + StringUtils.level(this.getSpeed(level)) + "效果时,每次攻击");
            lore.add("   §7获得的能量减半");
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
