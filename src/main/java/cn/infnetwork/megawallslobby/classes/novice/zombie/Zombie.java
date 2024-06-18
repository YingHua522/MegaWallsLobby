package cn.infnetwork.megawallslobby.classes.novice.zombie;

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

public class Zombie extends Classes {
    public Zombie() {
        super("Zombie", "僵尸", ChatColor.DARK_GREEN, Material.ROTTEN_FLESH, (byte) 0, ClassesType.NOVICE, new Orientation[]{Orientation.TANK, Orientation.ASSIST}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDkxMTMzOTk3OTIsInByb2ZpbGVJZCI6IjkxOGEwMjk1NTlkZDRjZTZiMTZmN2E1ZDUzZWZiNDEyIiwicHJvZmlsZU5hbWUiOiJCZWV2ZWxvcGVyIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9kYzQ4ODY1ZmRhZmU4NjA5MzkyMTgxNjcxMjIwZjlhNjFlYjljMWU2ZWU5YjQ3NDkzYzA4YjllYzE1Mjg0MGNmIn19fQ==", "HW1oBtR1Tcyb2XNf7VpeO2r6qsZ9hkSRmDzO3RwKgRd45q3ZnNxhMzC+wOf78IXygzRg791caKaOwSlGeZI7UdwbTr/0gMe4eEHNqnWFTmSUwgCB9z3Zm9HY3uNd8sprUHYPMwzgCHY1BLdSFYnTj/ox6kPZCfHRbPzCxXws1xDBkX7VyKZ8i4vdDxXTYRUxzlj7N1D2CgUz419WzLwwZKMDv6cfb6igaW4TsbidzKrwWarWoNk4ndSGWNsFgSvtIXCDhaerv43zlDDsJvtHsF8wMLJOA5/vPNwSrNuHltyMxiRtfppcsbjDFLrYxe2XQopt/DDDKytvLqkYDixU2vHzmIa6vRqxrhkcG54Mc17kq+kYrKaV9G09UwSDWUbzrujFoToF7mhEwAyMiioIoicU/dBBeCcUSsTy22VeNwDChuBpejNkR9zh51FeHwkiuEGExyQwB8j3FF6kP9oUBX2oJSp+l4G/ptomVsErprzsUDbXPy4wLwiq1yQoU2svBwWRwUmN5fx3bUjmshbfvMWOlMBT0APV5qDRIg39FDLAzzNR4mEnarecozDyZbJAbonTgOZAN/lLBhCnoyPBrdJC0fQ74abxDKdyfOVrP78HCrzQqFA00QqBGDNbV9z+dpHXgfG7bWba6N7loET1DO9uxPOPIxTTONXRDAKS1Qo=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " PickAxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Heal (10\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Zombie.this.nameColor + Zombie.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §a+ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax3");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I §8➜ §aII");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II §8➜ §aIII");
                        lore.add(" §8▪ §7速度药水 II §88❤ ➜ §a10❤");
                        lore.add(" §8▪ §7速度药水 II §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 III §8➜ §aII");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        return new ArrayList();
    }

    public int unlockCost() {
        return 0;
    }

    public int energyMelee() {
        return 13;
    }

    public int energyBow() {
        return 13;
    }
}
