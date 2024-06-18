package cn.infnetwork.megawallslobby.classes.novice.enderman;

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

public class Enderman extends Classes {
    public Enderman() {
        super("Enderman", "末影人", ChatColor.DARK_PURPLE, Material.ENDER_PEARL, (byte) 0, ClassesType.NOVICE, new Orientation[]{Orientation.AGILITY, Orientation.CHARGER}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDkxNTU5OTY3MzEsInByb2ZpbGVJZCI6IjU2Njc1YjIyMzJmMDRlZTA4OTE3OWU5YzkyMDZjZmU4IiwicHJvZmlsZU5hbWUiOiJUaGVJbmRyYSIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ0ZGIyNzEwNmZhYTYwYzRhOWE0ZDNlMmE0MDVlOGM2ODYzNWJjYzZkNjViMDhjZDI5NzllNjA2MTNkNTMwMiJ9fX0=", "KTYuXTQQ63ew7EksUSwP5XEQtdUkZh7G8ZoX4mBh10fWX0OXJIURP0c7PxW7BiPfh3o5Fo5zSeUIEHcbW9tjvhxmGkjONviLkA13VehIGMIo5h5akdkhEajLJgxJyOJSlLxicFhOoEy4cVDZwmAgwQrqidyH8ipOw9Hm4RbL2mKRX3Q+oEwyc4eDetIGbLTsoeueUq88QvtfISK2f3vDftIN92mznZcP3/k/tT3Y/7CO2iGEmjpMADhrbgxCk7AgjdWhZoz43xTJED631j5JuQbnO7/eaiQXIqpBAWTWFhRX/m3b7W8znbmAemgG5LjfertqFQNseICMmvFzUjDUHbYZ82Nmvu+ii1KoIOhXGQG1mI7ri/oejdXCvg8kAfp0HrNE9GdzvPItqBDC7OCwNzLkOI7T75hXhyABppUdty52GJ2i0GHQl679Vhs5bRhnRjlyPCUvhFDrgLr4cZgXaWmaDiEJ5DjxAiJOV9UDvXOxovb1mQlhoTCytQVhXSeuKLsNlVpoWKgEPRIrDWlqUadpKtsL14+t0p9zg+69FCmpYF1nWLPxKCC3zmFU3ixr3PVIzrUJ5VOBlee7xBx7pVeIuodYKcKduQNLkHjoV8o/gtaj9Bc3ohjVgygcRazrtePmm/ZbOCtrUjyC+pFmDgnIZE0m2KkLkcEdawzB5Zo=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Boots").setLore("\u00a7975%Fall Damage").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Boots").setLore("\u00a7975%Fall Damage").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Boots").setLore("\u00a7975%Fall Damage").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Boots").setLore("\u00a7975%Fall Damage").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Boots").setLore("§975%Fall Damage").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Enderman.this.nameColor + Enderman.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §a+ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 4:
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7速度药水 II §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
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
        return 30;
    }

    public int energyBow() {
        return 30;
    }
}
