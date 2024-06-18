package cn.infnetwork.megawallslobby.classes.mythic.phoenix;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesInfo.Difficulty;
import cn.infnetwork.megawallslobby.classes.ClassesInfo.Orientation;
import cn.infnetwork.megawallslobby.classes.ClassesType;
import cn.infnetwork.megawallslobby.classes.EquipmentPackage;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Phoenix extends Classes {
    public Phoenix() {
        super("Phoenix", "凤凰", ChatColor.YELLOW, Material.SULPHUR, (byte) 0, ClassesType.MYTHIC, new Orientation[]{Orientation.REMOTE, Orientation.ASSIST}, Difficulty.FOUR);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDg4MTY2MjY2NTUsInByb2ZpbGVJZCI6IjdkYTJhYjNhOTNjYTQ4ZWU4MzA0OGFmYzNiODBlNjhlIiwicHJvZmlsZU5hbWUiOiJHb2xkYXBmZWwiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzlkNTdjOGI1NzBmYjRkOGRiYWQ2YjU3MjM3MjMwMzQ3ZjdhZjlhOTM4ZGExMDY5NGI5MmIwYmE1NDdiMTgxODYifX19", "lbdM3m3EL7PRLk1sqUKX7/6RbOgJ7KPSAn+xZN5hmHUFSfwiWpvIWcgziSfG4/6QpWzk2hwkC5zX1olHDNS/8LQPh/4iNay8OIJsKUIBh3EnUW2P3Ft5J0ibEqyeNbMQ3L+eAZ++KUjtjDEmwwrkMzian7sknn8LLfKusecwm/PQUWyY6Sgm883jA5rcjtZsewnW0gQ3ZpIaxbeRI7o52EiY7NCkeIyE0wvJZ3XY0bBAPVOX85IFf8GsgKeeg6XhXnc/vZHfQOLrezoXygBrQOm/1/wppK2fFpcERmkLm5VN9ECdcbt9Mt+S3rGM4XBBcwTTT+OgNczI4CZzPyu1mT5ijF3JY3+U1pyRBGpggXcT0czFeutGnbyLKnSmEBKjHTIkmE4n2CjVasEbePAB/Vx3pWg+qZ40yhIelPLhEv36HjPhRZ6KH+zM1+85R3uhcVWbFYT1cYv0+e+P4CEJPq4bpzHA/LZTkagxIWEa1CS+Ffzuft55TW5R5CRKBviiI2x6klU2uvtxa12JiRE8TyujYjRZP5OxSQ9uXybKM6f6PWigKVQoRN32dsjwXoT83IPQYpkpfkT/AehtFM1DYaDVgsXPrZyEAxddYCyrwR43o2qgndpS/4qi/g6M3LTjF03sYnGVy1CPAuvaW2TSauLuplgmqpw1Kcojo3nnJWQ=");
        this.setEquipmentPackage(new EquipmentPackage(this) {
            public List<ItemStack> getEquipments(int level) {
                List<ItemStack> items = new ArrayList();
                items.add((new ItemBuilder(Material.COMPASS)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 指南针").build());
                items.add((new ItemBuilder(Material.DIAMOND_PICKAXE)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 镐").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add((new ItemBuilder(Material.ENDER_CHEST)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 末影箱").build());
                switch (level) {
                    case 1:
                        items.add((new ItemBuilder(Material.IRON_SWORD)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 剑").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.BOW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 弓").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).build());
                        items.add((new ItemBuilder(Material.IRON_CHESTPLATE)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 胸甲").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.IRON_LEGGINGS)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 护腿").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.POTION, 1, (byte) 5)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 治疗药水 (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add((new ItemBuilder(Material.ARROW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 箭").build());
                        items.add((new ItemBuilder(Material.COOKED_FISH, 2)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 烤制 鲑鱼").build());
                        break;
                    case 2:
                        items.add((new ItemBuilder(Material.IRON_SWORD)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 剑").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.BOW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 弓").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add((new ItemBuilder(Material.IRON_CHESTPLATE)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 胸甲").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add((new ItemBuilder(Material.IRON_LEGGINGS)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 护腿").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add((new ItemBuilder(Material.POTION, 1, (byte) 5)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 治疗药水 (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add((new ItemBuilder(Material.POTION, 1, (byte) 2)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 速度药水 II (0:15秒)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add((new ItemBuilder(Material.ARROW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 箭").build());
                        items.add((new ItemBuilder(Material.COOKED_FISH, 4)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 烤制 鲑鱼").build());
                        break;
                    case 3:
                        items.add((new ItemBuilder(Material.IRON_SWORD)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 剑").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.BOW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 弓").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add((new ItemBuilder(Material.IRON_CHESTPLATE)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 胸甲").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add((new ItemBuilder(Material.IRON_LEGGINGS)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 护腿").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add((new ItemBuilder(Material.POTION, 1, (byte) 5)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 治疗药水 (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add((new ItemBuilder(Material.POTION, 2, (byte) 2)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 速度药水 II (0:15秒)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add((new ItemBuilder(Material.ARROW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 箭").build());
                        items.add((new ItemBuilder(Material.COOKED_FISH, 4)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 烤制 鲑鱼").build());
                        break;
                    case 4:
                        items.add((new ItemBuilder(Material.IRON_SWORD)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 剑").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.BOW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 弓").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 2).build());
                        items.add((new ItemBuilder(Material.IRON_CHESTPLATE)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 胸甲").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add((new ItemBuilder(Material.IRON_LEGGINGS)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 护腿").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add((new ItemBuilder(Material.POTION, 2, (byte) 5)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 治疗药水 (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add((new ItemBuilder(Material.POTION, 2, (byte) 2)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 速度药水 II (0:15秒)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add((new ItemBuilder(Material.ARROW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 箭").build());
                        items.add((new ItemBuilder(Material.COOKED_FISH, 6)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 烤制 鲑鱼").build());
                        break;
                    case 5:
                        items.add((new ItemBuilder(Material.IRON_SWORD)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 剑").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add((new ItemBuilder(Material.BOW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 弓").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 2).build());
                        items.add((new ItemBuilder(Material.IRON_CHESTPLATE)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 胸甲").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add((new ItemBuilder(Material.IRON_LEGGINGS)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 护腿").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add((new ItemBuilder(Material.POTION, 2, (byte) 5)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 治疗药水 (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add((new ItemBuilder(Material.POTION, 2, (byte) 2)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 速度药水 II (0:15秒)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add((new ItemBuilder(Material.ARROW)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 箭").build());
                        items.add((new ItemBuilder(Material.COOKED_FISH, 6)).setDisplayName(Phoenix.this.nameColor + Phoenix.this.getDisplayName() + " 烤制 鲑鱼").build());
                }

                return items;
            }

            public List<String> getInfo(int level) {
                List<String> lore = new ArrayList();
                switch (level) {
                    case 1:
                        lore.add(" §8▪ §7铁 剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 无限 I");
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7箭");
                        lore.add(" §8▪ §7煮熟的 鲑鱼 §8x2");
                        break;
                    case 2:
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 无限 I");
                        lore.add("    §a+ 力量 I");
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7速度药水 II");
                        lore.add(" §8▪ 8▪ 0:15");
                        lore.add(" §8▪ §7煮熟的 鲑鱼 §8x2 ➜ §ax4");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §a+ 弹射物保护 I");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7速度药水 II  §8x1 ➜ §ax2");
                        lore.add(" §8▪ 8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 无限 I");
                        lore.add("    §8▪ 力量 I §8➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7煮熟的 鲑鱼 §8x4 ➜ §ax6");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I §8➜ §aII");
                        lore.add("    §8▪ 弹射物保护 I");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add("    §8▪ 弹射物保护 I");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你想帮助你的队友.");
        lore.add("§7你想要有机会复活.");
        lore.add("§7你很有耐心.");
        return lore;
    }

    public int unlockCost() {
        return 3;
    }

    public int energyMelee() {
        return 6;
    }

    public int energyBow() {
        return 12;
    }
}
