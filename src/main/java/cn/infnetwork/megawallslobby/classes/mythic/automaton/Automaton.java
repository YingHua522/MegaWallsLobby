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
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.mythic.automaton;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesInfo;
import cn.infnetwork.megawallslobby.classes.ClassesType;
import cn.infnetwork.megawallslobby.classes.EquipmentPackage;
import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Automaton extends Classes {
    public static final Map<GamePlayer, Integer> skill2 = new HashMap<GamePlayer, Integer>();

    public Automaton() {
        super("Automaton", "机器人", ChatColor.YELLOW, Material.WATCH, (byte) 0, ClassesType.MYTHIC, new ClassesInfo.Orientation[]{ClassesInfo.Orientation.HURT, ClassesInfo.Orientation.TANK}, ClassesInfo.Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("7","");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Leggings").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 3, (byte) 5).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Heal (6\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 1)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Automaton.this.nameColor + Automaton.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7铁 Chestplate");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7Potion of Heal 8❤");
                        lore.add(" §8▪ §7Steak");
                        break;
                    }
                    case 2: {
                        lore.add("§8• §7铁 Chestplate");
                        lore.add("    §8• 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add("§a+ §7Potion of Speed II");
                        lore.add("    §8• 0:15");
                        lore.add("§8• §7Steak §8x1 ➜ §ax2");
                        break;
                    }
                    case 3: {
                        lore.add("§8• §7铁 ➜ §a钻石 §7Sword");
                        lore.add("    §8• 耐久 X");
                        lore.add("§8• §7Potion of Speed §8x1 ➜ §ax2");
                        lore.add("    §8• 0:15");
                        break;
                    }
                    case 4: {
                        lore.add("§8• §7铁 Chestplate");
                        lore.add("    §8• 耐久 X");
                        lore.add("    §8• 保护 I ➜ §aII");
                        lore.add("§8• §7Potion of Heal 8♥ §8x1 ➜ §ax2");
                        lore.add("§8• §7Steak §8x2 ➜ §ax3");
                        break;
                    }
                    case 5: {
                        lore.add("§8• §7铁 ➜ §a钻石 §7Chestplate");
                        lore.add("    §8• 耐久 X");
                    }
                }
                return lore;
            }
        });
    }

    @Override
    public List<String> getInfo() {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7你更爱近战.");
        lore.add("§7你想要生存.");
        lore.add("§7你也想帮助队友生存.");
        return lore;
    }

    @Override
    public int unlockCost() {
        return 10;
    }

    @Override
    public int energyMelee() {
        return 4;
    }

    @Override
    public int energyBow() {
        return 6;
    }
}
