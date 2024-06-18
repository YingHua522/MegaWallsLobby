package cn.infnetwork.megawallslobby.classes.normal.pirate;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.CollectSkill;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import cn.infnetwork.megawallslobby.util.StringUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FourthSkill extends CollectSkill {
    public static final List<ItemStack> items = new ArrayList();

    static {
        items.add((new ItemBuilder(Material.PUMPKIN_PIE, 6)).setDisplayName("§e南瓜派").setLore(new String[]{"§7获得12点能量。"}).build());
        items.add((new ItemBuilder(Material.BOW)).setDisplayName("§6友好的椰子弓").addEnchantment(Enchantment.ARROW_KNOCKBACK, 1).build());
        items.add((new ItemBuilder(Material.ARROW, 12)).build());
    }

    public FourthSkill(Classes classes) {
        super("宝藏掠夺者", classes);
    }

    public int maxedLevel() {
        return 3;
    }

    public double getAttribute(int level) {
        switch (level) {
            case 1:
                return 0.3D;
            case 2:
                return 0.4D;
            case 3:
                return 0.5D;
            default:
                return 0.3D;
        }
    }

    public List<String> getInfo(int level) {
        List<String> lore = new ArrayList();
        if (level == 1) {
            lore.add(" §8▪ §7当你击杀一名敌人,将有§a" + StringUtils.percent(this.getAttribute(level)) + "§7的");
            lore.add("   §7几率额外掉落宝箱。在死斗模式中,");
            lore.add("   §7几率会提升至§a" + StringUtils.percent(this.getAttribute(level) * 2.0D) + "§7。宝箱可能含");
            lore.add("   §7海盗专属物品。");
            return lore;
        } else {
            lore.add(" §8▪ §7当你击杀一名敌人,将有§8" + StringUtils.percent(this.getAttribute(level - 1)) + " ➜ §a" + StringUtils.percent(this.getAttribute(level)) + "§7的");
            lore.add("   §7几率额外掉落宝箱。在死斗模式中,");
            lore.add("   §7几率会提升至§8" + StringUtils.percent(this.getAttribute(level - 1) * 2.0D) + " ➜ §a" + StringUtils.percent(this.getAttribute(level) * 2.0D) + "§7。宝箱可能含");
            lore.add("   §7海盗专属物品。");
            return lore;
        }
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addSkill4Level();
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getSkill4Level();
    }
}
