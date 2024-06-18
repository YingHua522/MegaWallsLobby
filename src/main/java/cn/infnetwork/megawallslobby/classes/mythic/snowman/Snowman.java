/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.citizensnpcs.api.CitizensAPI
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.ProjectileLaunchEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.mythic.snowman;


import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesInfo;
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

public class Snowman extends Classes {

    public Snowman() {
        super("Snowman", "雪人", ChatColor.AQUA, Material.SNOW_BALL, (byte) 0, ClassesType.MYTHIC, new ClassesInfo.Orientation[]{ClassesInfo.Orientation.CHARGER, ClassesInfo.Orientation.CONTROL}, ClassesInfo.Difficulty.FOUR);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("7","");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).build());
                        items.add(new ItemBuilder(Material.ARROW, 32).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.ARROW, 56).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.ARROW, 64).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.ARROW, 16).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 2).build());
                        items.add(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FIRE, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).build());
                        items.add(new ItemBuilder(Material.ARROW, 56).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
                        items.add(new ItemBuilder(Material.DIAMOND_SPADE).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Shovel").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Snowman.this.nameColor + Snowman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).addPotion(new PotionEffect(PotionEffectType.ABSORPTION, 300, 0)).build());
                    }
                }
                return items;
            }

            @Override
            public List<String> getInfo(int level) {
                ArrayList<String> lore = new ArrayList<String>();
                switch (level) {
                    case 1: {
                        lore.add(" §8▪ §7铁 Sword");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7Bow");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 力量 I");
                        lore.add(" §8▪ §7铁 Leggings");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add(" §8▪ §7Potion of Heal 8❤");
                        lore.add(" §8▪ §7Arrow §8x32");
                        lore.add(" §8▪ §7Steak");
                        break;
                    }
                    case 2: {
                        lore.add(" §8▪ §7铁 Leggings");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add("    §a+ 弹射物保护 I");
                        lore.add(" §a+ §7Potion of Speed II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7Arrow §8x32 ➜ §ax56");
                        lore.add(" §8▪ §7Steak §8x1 ➜ §ax2");
                        break;
                    }
                    case 3: {
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7Sword");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 Leggings");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add("    §8▪ 火焰保护 I ➜ §aII");
                        lore.add("    §8▪ 弹射物保护 I");
                        lore.add(" §8▪ §7Potion of Speed §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7Arrow §8x56 ➜ §ax64");
                        lore.add(" §8▪ §7Arrow §8x56 ➜ §ax16");
                        break;
                    }
                    case 4: {
                        lore.add(" §8▪ §7Bow");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 力量 I ➜ §aII");
                        lore.add(" §8▪ §7铁 Leggings");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II");
                        lore.add("    §8▪ 火焰保护 II");
                        lore.add("    §8▪ 弹射物保护 I ➜ §aII");
                        lore.add(" §8▪ §7Potion of Heal 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7Arrow §8x64 ➜ §ax40");
                        lore.add(" §8▪ §7Steak §8x2 ➜ §ax3");
                        break;
                    }
                    case 5: {
                        lore.add(" §8▪ §7铁 Leggings");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II ➜ §aIII");
                        lore.add("    §8▪ 火焰保护 II");
                        lore.add("    §8▪ 弹射物保护 II");
                    }
                }
                return lore;
            }
        });
    }

    @Override
    public List<String> getInfo() {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7你的献祭之殇高于一切.");
        lore.add("§7你喜欢燃着的东西,就比如,敌人.");
        return lore;
    }

    @Override
    public int unlockCost() {
        return 10;
    }

    @Override
    public int energyMelee() {
        return 8;
    }

    @Override
    public int energyBow() {
        return 2;
    }
}

