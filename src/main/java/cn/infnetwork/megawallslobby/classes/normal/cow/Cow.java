package cn.infnetwork.megawallslobby.classes.normal.cow;

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

public class Cow extends Classes {
    public Cow() {
        super("Cow", "牛", ChatColor.LIGHT_PURPLE, Material.MILK_BUCKET, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.TANK, Orientation.ASSIST}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0MzY4MDcwMDQsInByb2ZpbGVJZCI6ImQ5MjEyMTRkYTBkYjQ3MGJhOThmZWMxNzNjYTBmNWY0IiwicHJvZmlsZU5hbWUiOiJrYXNkb18iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzUxYTBkOGIwOGMzNWNhZTI0YmRlMGE3NDdlMmY0MGQzZDU4NGY5OGY3Mzk4ZWY2ZjMzMzRiMGM4NDFjMTkxODkifX19", "jxQCtzpkHbujfZEKMlTXSKIn9D1/1KLqYfuGR+Lgqf6mS4vzkKyL+29i92wiUkWCXS1H3MFKHtAYdOsNPhL/pLzfzHyXkT8RAhKzbH4z4UL2V08uymXKIef5VnjD/Qok4az/IWby6HFFTEH7NedwutLQ+fNZ8DyV2BIfQp9ZHc92l444fPy9TZx9hBXrNnkzs5yYO1XDPeBDfutiD9flen8W2F6EnjgsHg838ACh5zYa0kU7tatHEUC0gPFNEVlDD+TwF3Y/6i3RKpLu8ufuMhBDRHDU2kn0DGvkEtXSo5ruUp+pDiR460eV4LbPaxX1lN3vjxSjhTb7RmGU4POKhDEJ7XW9BjvGKECnNxyOs9VTt9ydLHNrg78gl3Nr12CoGYq3nKSretbzjlxTIehzqxpJbWytdDMZ5R8AeqMAQtaaHCueKOOXFjC3Ym29/B764Dku834XujpN3tBlyMWGHYORp+4HO5u6ijNt9lFedhezhlWHSH4UH3i2J0HjiUJ/98pvpJGFw5P4bXGwjL/IT1JK2d+CoOgU4CuDo6MBWZTGXxDqo/ov2Xnkvyp7u2j79VN80RM3M+79YEoPvzoLozPUOS9dc+AZppCQVlTi7df0RuBurh364QTqMOPhX0SaiYoNT+U4zFsYSVpVWhoFk0TR+Sw93XEPV3c8EumsNGc=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.MILK_BUCKET).build());
                        items.add(new ItemBuilder(Material.BREAD, 2).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Bread").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.MILK_BUCKET).build());
                        items.add(new ItemBuilder(Material.BREAD, 4).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Bread").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.MILK_BUCKET, 2).build());
                        items.add(new ItemBuilder(Material.BREAD, 4).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Bread").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
                        items.add(new ItemBuilder(Material.MILK_BUCKET, 2).build());
                        items.add(new ItemBuilder(Material.BREAD, 6).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Bread").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.MILK_BUCKET, 21).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Milk").build());
                        items.add(new ItemBuilder(Material.BREAD, 6).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Bread").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Heal (10\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Cow.this.nameColor + Cow.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                    }
                }
                return items;
            }

            public List<String> getInfo(int level) {
                List<String> lore = new ArrayList();
                switch (level) {
                    case 1:
                        lore.add(" §8▪ §7铁 剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛奶桶");
                        lore.add(" §8▪ §7面包 §8x2");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7面包 §8x2 ➜ §ax4");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛奶桶 §8x1 ➜ §ax2");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7面包 §8x4 ➜ §ax6");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 III ➜ §aI");
                        lore.add(" §8▪ §7牛奶桶 §8x2 ➜ §ax3");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你想帮助队友.");
        lore.add("§7你还想要防御和生存.");
        lore.add("§7哞~");
        return lore;
    }

    public int unlockCost() {
        return 25000;
    }

    public int energyMelee() {
        return 20;
    }

    public int energyBow() {
        return 15;
    }
}
