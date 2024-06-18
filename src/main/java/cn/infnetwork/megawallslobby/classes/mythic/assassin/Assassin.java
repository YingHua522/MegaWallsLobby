/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.citizensnpcs.api.CitizensAPI
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.player.PlayerItemConsumeEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.mythic.assassin;

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

public class Assassin extends Classes {

    public Assassin() {
        super("Assassin", "刺客", ChatColor.DARK_RED, Material.STAINED_GLASS, (byte) 15, ClassesType.MYTHIC, new ClassesInfo.Orientation[]{ClassesInfo.Orientation.HURT, ClassesInfo.Orientation.AGILITY}, ClassesInfo.Difficulty.FOUR);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("", "");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 5, (byte) 4).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Potion of Heal III and Speed II(0:06\u79d2)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 120, 2)).addPotion(new PotionEffect(PotionEffectType.SPEED, 200, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 5).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 5, (byte) 4).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Potion of Heal III and Speed II(0:06\u79d2)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 120, 2)).addPotion(new PotionEffect(PotionEffectType.SPEED, 200, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 5).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 5, (byte) 4).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Potion of Heal III and Speed II(0:06\u79d2)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 120, 2)).addPotion(new PotionEffect(PotionEffectType.SPEED, 200, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 5).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 5, (byte) 4).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Potion of Heal III and Speed II(0:06\u79d2)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 120, 2)).addPotion(new PotionEffect(PotionEffectType.SPEED, 200, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 5).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 5, (byte) 4).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Potion of Heal III and Speed II(0:06\u79d2)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 120, 2)).addPotion(new PotionEffect(PotionEffectType.SPEED, 200, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 5).setDisplayName(Assassin.this.nameColor + Assassin.this.getDisplayName() + " Steak").build());
                    }
                }
                return items;
            }

            @Override
            public List<String> getInfo(int var1) {
                ArrayList<String> lore = new ArrayList<>();
                switch (var1) {
                    case 1: {
                        lore.add("§8• §7铁剑");
                        lore.add(" §8• 耐久 X");
                        lore.add("§8• §7铁胸甲");
                        lore.add(" §8• 耐久 X");
                        lore.add("§8• §7治疗药水 6♥");
                        lore.add("§8• §7速度药水 II 和 跳跃提升 V");
                        lore.add(" §8• 0:15");
                        lore.add("§8• §7牛排");
                        break;
                    }
                    case 2: {
                        lore.add("§8• §7铁胸甲");
                        lore.add("    §8• 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add("§8• §7牛排 §8x1 ➜ §ax2");
                        break;
                    }
                    case 3: {
                        lore.add("§8• §7铁胸甲");
                        lore.add("    §8• 耐久 X");
                        lore.add("    §8• 保护 I ➜ §aII");
                        lore.add("§8• §7治疗药水 6♥ ➜ §a8♥");
                        lore.add("§8• §7速度药水 II 和 跳跃提升 V §8x1 ➜ §ax2");
                        lore.add("    §8• 0:15");
                        lore.add("§8• §7牛排 §8x2 ➜ §ax3");
                        break;
                    }
                    case 4: {
                        lore.add("§8• §7铁 ➜ §a钻石 §7剑");
                        lore.add("    §8• 耐久 X");
                        lore.add("§8• §7铁胸甲");
                        lore.add("    §8• 耐久 X");
                        lore.add("    §8• 保护 II ➜ §aIII");
                        lore.add("§8• §7牛排 §8x3 ➜ §ax4");
                        break;
                    }
                    case 5: {
                        lore.add("§8• §7铁 ➜ §a钻石 §7胸甲");
                        lore.add("    §8• 耐久 X");
                        lore.add("§8• §7速度药水 II 和 跳跃提升 V §8x2 ➜ §ax3");
                        lore.add("    §8• 0:15");
                        lore.add("§8• §7牛排 §8x4 ➜ §ax5");
                    }
                }
                return lore;
            }
        });
    }


    @Override
    public List<String> getInfo() {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7你想要有技能来保证你持续点击左键.");
        lore.add("§7你想要冲所有队伍的凋灵.");
        return lore;
    }

    @Override
    public int unlockCost() {
        return 5;
    }

    @Override
    public int energyMelee() {
        return 10;
    }

    @Override
    public int energyBow() {
        return 10;
    }
}


