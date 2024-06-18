package cn.infnetwork.megawallslobby.classes.normal.arcane;

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

public class Arcane extends Classes {
    public Arcane() {
        super("Arcane", "奥术师", ChatColor.RED, Material.FIREWORK, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.WARRIOR, Orientation.HURT}, Difficulty.ONE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0MzUxMTYzOTQsInByb2ZpbGVJZCI6IjFjZjQ0OTMwODY1MTQ4NGE5ZmZjODI5YjlmNDg3NGE2IiwicHJvZmlsZU5hbWUiOiJJbmdBbmciLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzg1Y2MzYTMyZmI5ZTM3ZDBiNjUwYmFiZDdmOWMzMjQ5NjA1NjJiNDI1NjYzNTJmNDI4MjAzYzg2YmZmYWQ5NmUifX19", "SDH0LQXVNhEQuWYzVH7brsvWBPsc72u7f+GYDlYnGSLDSu2Sr2IirE8rOt0l7r6B/G7Q37+UAe7a2kO/nlQiM7pdx8aeBZoBd+bHJnJ7NwyvHc1NC/EZH9Hw9VfCRD6QXgQplsNx3dLYQXzPX0piFMN+w6aW6lAGkTJVvI8zVWM4rwYY3/73eVgef3K2Ny4OZ2BBPnZlhk+huGac+hI+n6RpXWkTMXwUpWDUHxy3GbxCwKj+Tr5/GWJjBQkUcywjRO+8/OHOAbOlpoAtbtW8jbN0G7RhX6mSUkV7iwlTqO5Fne4DLMgto0W9y4Z7Pz2lySnwLiDdhoaWGWeUxMDcTg0zKC1TeMzfot68QOD3YayGs+achr77TFt9HTrmg0gm8ykdstdC19SGSqkt+XyIGR/x8agT5cySRXfcB2oZLdq8UXuXbFIDxg2c3M5RM/AY5E22MKpzbsjQEs8MKoebdkgyC5FrcOAXA9BU9uX2FT/K6/xV0HJxli94j0JkT6ZLYCk4fixYSJSDHcLi+LUpXs5iMOxvM7mZEPW2s0a68uxksZ8ScNboUSlUqtvzkfTaAfOPA/T+dGYiUhThic6kGnbqnGwJdasmtZnAVEP3fkT7gv+tcA4oMqty003MKNkqPjLNFQu9TVcqpXFTgOFJ9eFIuqPS3Ymr3nh1dU3eODI=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Arcane.this.nameColor + Arcane.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 爆炸保护 I");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add("    §8▪ 爆炸保护 I");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §8▪ 爆炸保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7钻石 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add("    §8▪ 爆炸保护 II");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你喜欢近战与远程的混合.");
        lore.add("§7你是方块挖掘高手.");
        lore.add("§7你是一名法师.");
        return lore;
    }

    public int unlockCost() {
        return 5000;
    }

    public int energyMelee() {
        return 36;
    }

    public int energyBow() {
        return 36;
    }
}
