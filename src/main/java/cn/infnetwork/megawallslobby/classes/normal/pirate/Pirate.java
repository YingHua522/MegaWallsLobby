package cn.infnetwork.megawallslobby.classes.normal.pirate;

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

public class Pirate extends Classes {
    public Pirate() {
        super("Pirate", "海盗", ChatColor.GOLD, Material.STONE_AXE, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.WARRIOR, Orientation.HURT}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0Mzc4NDUyNzYsInByb2ZpbGVJZCI6ImRhNzQ2NWVkMjljYjRkZTA5MzRkOTIwMTc0NDkxMzU1IiwicHJvZmlsZU5hbWUiOiJLaWRTbGljZXIiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2VjMzk1Mzc0OTc5MGQ1M2NlODkwZmVlN2UzMDY5NzQwNTIwZmJiMjQyNjJmY2VlNWZjNjAwNGNmODcyMDVhZDkifX19", "sjMOCPlowVjBHyHMUaNahonctz7XZtsquJp6WEPX4m9KGjFUtBij/AYNToPpOo5liF/pngv+1hTWd4l341rY/ZC44W+S82hklku5mdprG9uSkxDyxuoFCBdGVaxzHY1rzIY++fNs1aoXFLJUtb62lxe8JA4j5VrDI/yoAREyKdqsFoazL38feeRYsnw3xXugy06PteiguQ848lGpqJDW9jCqjcxU75YBaqGiPGEPNGkTQQbfGoJkDwmQ3HCRnvOJ/YwKZ8OLzWWxmCouI1MKOztE3kao8lAwxJ3LYUyApzBRIrlPXhhh5ZrMock85rXAky2EYYvebAO03qoT9lbVLvm/CvQ57Y5jap696/V0mG4IleDW743itu2G9OBt9kqrwodn6IzQ4ln2i7C2ggIa361MCjbObH2tZ/s2Uyaa+EgzVTqGAbUY3I9nhBpWGPPiRqWgOC0Ug+T6912sZd7wyFerwmZlxSESal5fpuFBukHFJhn54XSsL0lhP2Gkl/b/5DeenvAVrTaODtCpx9K0bRnBkKjQpoEkd/AsVm3OaO6h73XL8F6QxWNW+DyovRlVvuSAr0Wzf/rIv4S9KwMsc7oLOu86mw9N8+t37y8BC48iJi9n0pfwdtZbAxVEDa3Gwmk6Ai7d/kZY6Qv55t1LM3kULBcq/elOvuvj0GBTBgk=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.ARROW, 32).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.ARROW, 56).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Potion of Heal (Regeneration III 0:09)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 180, 2)).addPotion(new PotionEffect(PotionEffectType.ABSORPTION, 1800, 1)).build());
                        items.add(new ItemBuilder(Material.ARROW, 64).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.ARROW, 16).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 2).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Potion of Heal (Regeneration III 0:09)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 180, 2)).addPotion(new PotionEffect(PotionEffectType.ABSORPTION, 1800, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Potion of Heal (Regeneration III 0:09)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 180, 2)).addPotion(new PotionEffect(PotionEffectType.ABSORPTION, 1800, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Pirate.this.nameColor + Pirate.this.getDisplayName() + " Steak").build());
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
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 力量 I");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7箭 §8x32");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add("    §a+ 弹射物保护 I");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7箭 §8x32 ➜ §ax56");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add("    §8▪ 火焰保护 I ➜ §aII");
                        lore.add("    §a+ 弹射物保护 I");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7箭 §8x56 ➜ §ax64");
                        lore.add(" §8▪ §7箭 §8x56 ➜ §ax16");
                        break;
                    case 4:
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II");
                        lore.add("    §8▪ 火焰保护 II");
                        lore.add("    §a+ 弹射物保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7箭 §8x64 ➜ §ax40");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II ➜ §aIII");
                        lore.add("    §8▪ 火焰保护 II");
                        lore.add("    §a+ 弹射物保护 II");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你想要在战斗中占据上风.");
        lore.add("§7你喜欢宝藏.");
        lore.add("§7Yarr^_^.");
        return lore;
    }

    public int unlockCost() {
        return 40000;
    }

    public int energyMelee() {
        return 12;
    }

    public int energyBow() {
        return 12;
    }
}
