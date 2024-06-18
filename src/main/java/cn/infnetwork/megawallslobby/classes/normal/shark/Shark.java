/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.citizensnpcs.api.CitizensAPI
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.player.PlayerItemConsumeEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.normal.shark;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesInfo;
import cn.infnetwork.megawallslobby.classes.ClassesType;
import cn.infnetwork.megawallslobby.classes.EquipmentPackage;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Shark extends Classes {

    public Shark() {
        super("Shark", "鲨鱼",  ChatColor.BLUE, Material.WATER_BUCKET, (byte) 0, ClassesType.NORMAL, new ClassesInfo.Orientation[]{ClassesInfo.Orientation.TANK, ClassesInfo.Orientation.CONTROL}, ClassesInfo.Difficulty.ONE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("7","");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 2).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 4).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 4).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Heal (6❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DEPTH_STRIDER, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 6).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 3, (byte) 5).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DEPTH_STRIDER, 3).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 6).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Shark.this.nameColor + Shark.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7铁 Boots");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add(" §8▪ §7Potion of Heal 8❤");
                        lore.add(" §8▪ §7Cooked Fish x2");
                        break;
                    }
                    case 2: {
                        lore.add(" §8▪ §7铁 Boots");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7Potion of Heal 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7烤制 鱼 §8x2 ➜ §ax4");
                        break;
                    }
                    case 3: {
                        lore.add(" §8▪ §7铁 Boots");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II ➜ §aIII");
                        lore.add(" §a+ §7Potion of Speed II");
                        lore.add("    §8▪ 0:15");
                        break;
                    }
                    case 4: {
                        lore.add(" §8▪ §7铁 Boots");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 III ➜ §aIV");
                        lore.add("    §a+ 深海探索者 I");
                        lore.add(" §8▪ §7铁 Boots");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 深海探索者 II");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7Potion of Heal 8❤ §8x2 ➜ §ax3");
                        lore.add(" §8▪ §7烤制 鱼 §8x4 ➜ §ax6");
                        break;
                    }
                    case 5: {
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7Boots");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 IV ➜ §aIII");
                        lore.add("    §8▪ 深海探索者 I ➜ §aII");
                    }
                }
                return lore;
            }
        });
    }

    public static float getDistance(final Location lc1, final Location lc2) {
        return (float) Math.sqrt(Math.pow(lc1.getX() - lc2.getX(), 2.0) + Math.pow(lc1.getY() - lc2.getY(), 2.0) + Math.pow(lc1.getZ() - lc2.getZ(), 2.0));
    }

    @Override
    public List<String> getInfo() {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7你想要在掌控局面的同时造成大量伤害.");
        lore.add("§7你喜欢在此之中灌输无尽的恐惧.");
        return lore;
    }

    @Override
    public int unlockCost() {
        return 15000;
    }

    @Override
    public int energyMelee() {
        return 18;
    }

    @Override
    public int energyBow() {
        return 18;
    }
}

