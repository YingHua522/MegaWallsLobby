package cn.infnetwork.megawallslobby.classes.normal.blaze;

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

public class Blaze extends Classes {
    public Blaze() {
        super("Blaze", "烈焰人", ChatColor.RED, Material.BLAZE_POWDER, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.REMOTE, Orientation.CONTROL}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0Mzc2OTkxODIsInByb2ZpbGVJZCI6ImE5MGI4MmIwNzE4NTQ0ZjU5YmE1MTZkMGY2Nzk2NDkwIiwicHJvZmlsZU5hbWUiOiJJbUZhdFRCSCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjVhNTQ4NmZmNjMyYTEyNTJhNjM5ZjFlZmZiYzhiNjZjYzMzMzNhOTQ2NDY0OGUzYzljY2I5MWQ4YzE0MzM3NiJ9fX0=", "ZOZnYDhaLvhdesAjSgzGH2jmI+7aPCcRYVKHRQvrVKR9WA6hwnTqCIKdATwSe5N7VIvk26SBAs/6CtzV4NdF6QDrbGtWDlMxCqrTQ9aIeQdeCezO+W5RGRlQAHVPAIl6iKYXtIEDOhT+mKJt3QNVoXDEGdk2AwKe7FYGH9SGaqVfOid/LtUr1+StQG7MKKemMOhsH6Lqe9U1ym5B0ADQQul+RN2kvX4MrtUsAd3wPrDHFhS8lwHONSUH9gojseFZ7wQj9hCRIhjtgUqyr20u7USKFScRR5PIbJgvGRk8oOtdoDiaLItOgqcljZGs24M4S8wN013zpBb4WkZwGKPBQdhFTJBYa4KfiE0OP1G5EgxQWgxtFF4fYPPMztLzx9ZI9jKBcsG3NPzVG+mKGs57mxC6H93yhmKofVKsWo1q7fU1kWc7yL7m2bM4xjAPPmXgJc9BmhUNEKcEbfa5IxTFjarKVZ/Y79ys57/jmysZ4CElVZexWM8iOeIb4mfEzVcN7tfsSCh0CYSimjW7XBupF+VqR2xPILn/WlaYGALFXSkA+2gvBiCTTlts44gnJ7oDdoMcu9WI3ATFGQSjWX5D/pPwdxwiKBrLUuKDkWfHT6754gVqtF8XqZqpjBda+lAhosxnl8w3IGLuvqydyisLdCMS8aSTbQ9rIpktBH0eMTQ=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).build());
                        items.add(new ItemBuilder(Material.ARROW, 32).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.ARROW, 56).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.ARROW, 64).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.ARROW, 16).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 2).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).build());
                        items.add(new ItemBuilder(Material.ARROW, 56).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 2).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).build());
                        items.add(new ItemBuilder(Material.ARROW, 56).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Blaze.this.nameColor + Blaze.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add("    §8▪ 弹射物保护 I");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7箭 §8x56 ➜ §ax64");
                        lore.add(" §8▪ §7箭 §8x56 ➜ §ax16");
                        break;
                    case 4:
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 力量 I ➜ §aII");
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II");
                        lore.add("    §8▪ 火焰保护 II");
                        lore.add("    §8▪ 弹射物保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7箭 §8x64 ➜ §ax40");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II ➜ §aIII");
                        lore.add("    §8▪ 火焰保护 II");
                        lore.add("    §8▪ 弹射物保护 II");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你的献祭之殇高于一切.");
        lore.add("§7你喜欢燃着的东西,就比如,敌人.");
        return lore;
    }

    public int unlockCost() {
        return 15000;
    }

    public int energyMelee() {
        return 8;
    }

    public int energyBow() {
        return 4;
    }
}
