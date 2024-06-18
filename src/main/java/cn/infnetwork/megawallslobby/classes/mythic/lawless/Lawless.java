/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.player.PlayerItemConsumeEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package cn.infnetwork.megawallslobby.classes.mythic.lawless;

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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lawless extends Classes {

    public Lawless() {
        super("Lawless", "不法者",  ChatColor.GOLD, Material.ARROW, (byte) 0, ClassesType.MYTHIC, new ClassesInfo.Orientation[]{ClassesInfo.Orientation.AGILITY, ClassesInfo.Orientation.REMOTE}, ClassesInfo.Difficulty.THREE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("7","");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_FALL, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.ARROW, 16).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FALL, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.ARROW, 24).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.ARROW, 32).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.ARROW, 40).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.ARROW, 48).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Steak").build());
                        ItemStack item = new ItemStack(Material.POTION);
                        item.setAmount(5);
                        item.setDurability((byte) 2);
                        PotionMeta im = (PotionMeta) item.getItemMeta();
                        im.setDisplayName(Lawless.this.nameColor + Lawless.this.getDisplayName() + " Splash Potion of Speed I (0:05s)");
                        im.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 300, 0), true);
                        im.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 0), true);
                        item.setItemMeta(im);
                        Potion pot = new Potion(1);
                        pot.setSplash(true);
                        pot.apply(item);
                        items.add(item);
                    }
                }
                return items;
            }

            @Override
            public List<String> getInfo(int level) {
                ArrayList<String> lore = new ArrayList<String>();
                switch (level) {
                    case 1: {
                        lore.add(" §8▪ §7铁 剑");
                        lore.add("    §8▪ 锋利 I");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 鞋子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 摔落保护 II");
                        lore.add(" §8▪ §7治疗药水 6❤");
                        lore.add(" §8▪ §7牛排");
                        break;
                    }
                    case 2: {
                        lore.add(" §8▪ §7铁 鞋子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 摔落保护 §8I ➜ §aII");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        break;
                    }
                    case 3: {
                        lore.add(" §8▪ §7治疗药水 6❤ ➜ §a8❤");
                        lore.add(" §8▪ §7速度药水 II §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    }
                    case 4: {
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7牛排 §8x3 ➜ §ax4");
                        break;
                    }
                    case 5: {
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7鞋子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 力量 I");
                    }
                }
                return lore;
            }
        });
    }

    @Override
    public List<String> getInfo() {
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7你想要近战与远程的混合体.");
        lore.add("§7你想要一个逃跑的紧急按钮.");
        lore.add("§7你能习惯2个技能.");
        return lore;
    }

    @Override
    public int unlockCost() {
        return 5;
    }

    @Override
    public int energyMelee() {
        return 17;
    }

    @Override
    public int energyBow() {
        return 17;
    }
}