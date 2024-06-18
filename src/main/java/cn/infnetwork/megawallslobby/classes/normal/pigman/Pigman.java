package cn.infnetwork.megawallslobby.classes.normal.pigman;

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

public class Pigman extends Classes {
    public Pigman() {
        super("Pigman", "猪人", ChatColor.LIGHT_PURPLE, Material.GRILLED_PORK, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.WARRIOR, Orientation.ASSIST}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0MzYyMzQ1NzIsInByb2ZpbGVJZCI6IjQ2N2NmOTRkY2UyYjQ1ZTY4YmRhNTJlNTUwMmU3M2U4IiwicHJvZmlsZU5hbWUiOiJMaWxpeWFfIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iMzljZTcyZjMzNDNjZjQ2OThiODM3YzZiNDEwZTEzNDIzYmMwNmZmMmNhNTc5ZWVkMTJjNGI2M2U4Y2RhMzNmIn19fQ==", "yfqmARuP/kxsS/RKy+tqqg62SRJ12yXQttAjjzNrrLEYen8RNBgAZxtxVnVFiQZXXs87YiDBzAwZcisTM+CKVr4E/ke8osIWOZnyeYsxaVjcud76X0BfSceTsFIAGHRXaDQ+0E1tWwioednO4HSbDWTklI1fcNFO4xjsft/Tzexn1DKwdpQ3hQJSYez7B7ZpGDQFzhgYZWpg8UciIouO0/R1S+nJgXbXNBVm2ClySmS66evXPPfOBEOVbbQQqvlPJveVyy89/nxNopchNmA3kpFnuzE7Pe8QozQ3ujOUEjkLb2qEHX0Ns5/UKS5ojyU6ravzNFMq0bHxlYoDT5AAl35OPWrQvg0DdwqfsTh5rBHCSEFbPaB2vXk4Vrobz/MazrGiKRfbWdHNOQEonknfSk+pGYmALr7tHuSePohHxJrjG4lLRgK3w9BK6qUh0BxcKxNT8c2DHkHpQfQ7cI2Z4BSEcEoA2KDejitnqlLAXPY3Bg5uP+SFy73TkJWLCXUw46xYE1mQJs+d6cwtfAyUp/F8OKcI7u6aCd2nm2lTVlKD6xtgpslZTh4j5wrKzcmXJ8x3WEXc8dXScEXkRM7IFumt6YDPSnZ4wqGPnXZZVR5P7sfanl+hN6pEaNQHgZoMuujaA2ZeeSH5MA4xPss+EjqWD0TWzXJt1rQdW6C1iD0=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Heal (10❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Pigman.this.nameColor + Pigman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7胸甲");
                        lore.add("    §8▪ 耐久 X");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你更爱近战.");
        lore.add("§7你想要生存.");
        lore.add("§7你也想帮助队友生存.");
        return lore;
    }

    public int unlockCost() {
        return 25000;
    }

    public int energyMelee() {
        return 10;
    }

    public int energyBow() {
        return 10;
    }
}
