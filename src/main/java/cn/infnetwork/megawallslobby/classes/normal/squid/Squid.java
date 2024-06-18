package cn.infnetwork.megawallslobby.classes.normal.squid;

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

public class Squid extends Classes {
    public Squid() {
        super("Squid", "鱿鱼", ChatColor.AQUA, Material.INK_SACK, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.TANK, Orientation.CONTROL}, Difficulty.ONE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0MzQ0NzE2NzksInByb2ZpbGVJZCI6ImVmYWY1NzU3NzgxZTQ3YWViYzE0Y2Q4MmM5MWM3ZjgyIiwicHJvZmlsZU5hbWUiOiJNaW5lU2tpbiIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NhZmVkZTU5MTZlM2FlOTVjMzY2ZGE4NWZmMmI3NTQ5ZjA3NzMzZTg5OTIxNzkxNjA5ZGU5MThmZTI2YTk0ZCJ9fX0=", "s86KHFEFFj90dD02apLFVAOX5mIjggI+mDiEedQhBaFxh/qB4dJPFMjl/l7X92RCmtsWD/XlcxLZCiKYX7i5Et/Xz+HN0ovxrrv6wTGCpNl5BfcFPgq1QkE31FvvPZowhcNoTAL5L8sq9pW2MQdvNE54PaJTl1Usd9otd4atsZHVOkHjSK0KkZ7HxE7sSn8CFXU7G1GQGxpk4WannwPv5sxdqeRKmdqEW/GgZPnH2C+Z0n648GJCKaea76U5NeaIWxGdY2ISEc8DBC9qUH0Q4AWmcn7S8GyNnSH85H0JVwiqIfZjGqTCjq32oJ8jN5tT4s8qeJppL9yg+JlEZ34fDxqHyrK2X1lDz91mRE4rjGS3V0uvOvJkOCkIjS2bJ8tGoh9pfKHLFtqrOgEBoVfRZOZnKw1UGfxN/UV++990m4C30uLxUuGzoY24vAGoyxW4fIqnqZdIugDiEZ8abVmAuhvtnSFUMO3DFGERVABnXSvZentCz4N6p7PWH+d4M1+6n2xcg4u/clxU0sJKW8wvw2RMg4ETlPUbf3I4brGnJAbkGOQKHPdy56OI8Y7nUDpTLztCSEvvEj/pqV+vX+W8mdtRivlRDwHlSgKxIOYgUooGSeKcDkP2i+eFD1BZrdNN1vB3IrQQtfJAtTU15624q6W5SCRnCLrhrvSe7Kd5mDE=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 2).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 4).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 4).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Heal (6❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DEPTH_STRIDER, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 6).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 3, (byte) 5).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Heal (5❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addEnchantment(Enchantment.DEPTH_STRIDER, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_FISH, 6).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Cooked Fish").build());
                        items.add(new ItemBuilder(Material.POTION, 3, (byte) 5).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Heal (5❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 1)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Squid.this.nameColor + Squid.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7烤制 鲑鱼 x2");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7烤制 鱼 §8x2 ➜ §ax4");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II ➜ §aIII");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 III ➜ §aIV");
                        lore.add("    §a+ 深海探索者 I");
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 深海探索者 II");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x2 ➜ §ax3");
                        lore.add(" §8▪ §7烤制 鱼 §8x4 ➜ §ax6");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 IV ➜ §aIII");
                        lore.add("    §8▪ 深海探索者 I ➜ §aII");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList<>();
        lore.add("§7你想要在掌控局面的同时造成大量伤害.");
        lore.add("§7你喜欢在此之中灌输无尽的恐惧.");
        return lore;
    }

    public int unlockCost() {
        return 15000;
    }

    public int energyMelee() {
        return 10;
    }

    public int energyBow() {
        return 10;
    }
}
