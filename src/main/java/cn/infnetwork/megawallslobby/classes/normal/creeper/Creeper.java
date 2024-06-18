package cn.infnetwork.megawallslobby.classes.normal.creeper;

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

public class Creeper extends Classes {
    public Creeper() {
        super("Creeper", "爬行者", ChatColor.GREEN, Material.TNT, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.HURT, Orientation.CONTROL}, Difficulty.FOUR);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0Mzc4NjM4MjQsInByb2ZpbGVJZCI6IjQ2N2NmOTRkY2UyYjQ1ZTY4YmRhNTJlNTUwMmU3M2U4IiwicHJvZmlsZU5hbWUiOiJMaWxpeWFfIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS80ZWI1OTFiYjI4MjdhYjEyMmVjYjQ1Y2QyM2JlMTc3Y2NlYTRlNjhhNDBkZGM2MjRjMjlhMzkyMTNhODUyYTNlIn19fQ==", "tASRja/DyrBoogF6V88aJYrZYaENBAJ3T37oqLqWnLxZucc7G8R/Eu7N7reoTAaZDElAjkVIHrxP8qR95EIO0cY/Z415l6jMzHsMcbTrWQ1Pw9QMFbstLpp+Xw38v7BLN+Xo00rh4nvPtNIv0Ozdb7V+9XXTntz9HRIbYIInqiSUeCKo6r8JmrhOjSCVhc1lHhNE/KDMT5sqvYREshvnE/5dX/+9YeVI14ufgtJ/IEuhk6fUdyDIgTg7fgU3TIpxRo4kT0Qd37ONhszIMSxMvbLohrZck6SYff8XuVPBSLBPaDHv9cwc1DwTEJ0+emEbVbIC3e8sLDfD1+byE+ZptXYjOiAfQypIzxSrECv9YuA8YkYI+yi+yButmaILbTZ3S4EazBGyeWkT/Gdb3tXMJV+uZnN5VxWKfJgULvh5bIjgXvPLYPoJKBoW1HljN2MvpnXaAMFBNU4+dWQ/Sr0/oc2MVbdWVbiow644aYuhTV+OZTkPFssALmt41NQd9eUBDn2MjBRhkvQuR0uVg3xciqQ3E2TF3taTly/dLw90L7MV9omWZRotVNKI7zPQmxM0rS+RB/l/q/23FlAAf5eUAHEO3mRRUTUEkfS3EnYVuGlfpTI+u4E8fJ6udPRorajHfARq+apXC5be6cHm7bH/fZxDFv0GluAFik/RFMPgOZA=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 6).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.TNT, 64).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Creeper.this.nameColor + Creeper.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add("    §8▪ 爆炸保护 II");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 爆炸保护 II ➜ §aIII");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 爆炸保护 III ➜ §aIV");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 爆炸保护 IV ➜ §aV");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7护腿");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 爆炸保护 V ➜ §aVI");
                        lore.add("    §8▪ 保护 I");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你想在连击时加入一些小爆炸.");
        lore.add("§7你想掌控你的生命.");
        lore.add("§7你喜欢给那些毫无防备的矿工们惊喜(惊吓).");
        return lore;
    }

    public int unlockCost() {
        return 25000;
    }

    public int energyMelee() {
        return 20;
    }

    public int energyBow() {
        return 20;
    }
}
