package cn.infnetwork.megawallslobby.classes.normal.puppet;

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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Puppet extends Classes {
    public Puppet() {
        super("Puppet", "傀儡", ChatColor.GRAY, Material.IRON_CHESTPLATE, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.TANK, Orientation.WARRIOR}, Difficulty.ONE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1MzE3MDU1ODc1NzAsInByb2ZpbGVJZCI6ImNhZjdmYWRiZDVkMDQ5OWQ4NTkyMmZhZTk2YmJiMjgwIiwicHJvZmlsZU5hbWUiOiJOb0hpdENvbWJvIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lNGI1NzFhZjQzYmFmMGRiYjY4MjQ5M2JkZTFjZTRlODQ3ZGI3NThkZDk2ODVlOWJlYzJiN2FiYmNjNzI3NzI2In19fQ==", "vJMUxavK9emxVhMl8THyI33lJmcV/feJrNDv5jkGCjXONkYArvxju+Y9Gjbjz/+cXzz6pZvfbHjIHE8uAsx4/WvJeCsEbpG5oHoIpi0VOBl8rJ7+J53d0428ExxYMeRCmpsnp+jihUbNYVOzej4UdWm58Q9sKnfw8AuvuUcKT90AbArkiRbqZTM1Lx5D3fdIVrJGKhZC1wg5rAXhGHINHQDau83qIKqSZI2wTJ5zYCb0F6g2xuq+j7Od354wiRLKjvjWyg5XqskRPHlWepD75IED6C+rPw0OT2wt7M6XKNnQ/AsqhYmT38v7ZLiiVCNXhDxYNPMiodI4NLoCYuWP8i5lGe3HHcKIzRQFCgEiZfVvDUvivuTyRoSlgT2IpgmD2qcLrOd3Ii0r1aRPsQfVLxmS//jVm5iZJOhm0DFF00qaT1Spd5/P0EKm1Ef6wquJ3Gsu9zaiiHz+rxA/+u+92CarDp5JQ0c4gLJadPXsgZYUTyOplbG2PNNRKEc3QKB+qBC24/8/wCiKGZRLYV6Pwhfn+VjdEk6BCCPKJerggWK5vl4AhYLl5Ycr1upWKnb8+4B3x7IfdI9wTv9hz77NUI88FExXsL46D+6V7kAdiPi3SEsLBgaTsbMCdkvO1w5Z1Y/l169FqL+qXWk28eKypBpnr++6nwRHSgHNdgzOp70=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_AXE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Axe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 1).addEnchantment(Enchantment.DURABILITY, 3).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_AXE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Axe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 1).addEnchantment(Enchantment.DURABILITY, 3).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 1).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Potion of Regen III (0:12秒)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 240, 2)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_AXE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Axe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 1).addEnchantment(Enchantment.DURABILITY, 3).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 1).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Potion of Regen III (0:12秒)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 240, 2)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_AXE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Axe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 1).addEnchantment(Enchantment.DURABILITY, 3).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 1).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Potion of Regen III (0:12秒)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 240, 2)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_AXE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Axe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 1).addEnchantment(Enchantment.DURABILITY, 3).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 1).setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Potion of Regen III (0:12s)").addPotion(new PotionEffect(PotionEffectType.REGENERATION, 240, 2)).build());
                        ItemStack item = new ItemStack(Material.POTION);
                        item.setAmount(2);
                        item.setDurability((byte) 2);
                        PotionMeta im = (PotionMeta) item.getItemMeta();
                        im.setDisplayName(Puppet.this.nameColor + Puppet.this.getDisplayName() + " Splash Potion of Slow I (0:05s)");
                        im.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0), true);
                        im.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 3), true);
                        item.setItemMeta(im);
                        Potion pot = new Potion(1);
                        pot.setSplash(true);
                        pot.apply(item);
                        items.add(item);

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
                        lore.add(" §8▪ §7铁 斧");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 效率 I");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §a+ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §a+ §7再生药水 III §8x2");
                        lore.add("    §8▪ 0:12");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7胸甲");
                        lore.add("    §8▪ 耐久 X");
                        break;
                    case 5:
                        lore.add(" §8▪ §7钻石 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7钻石 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你喜欢近战.");
        lore.add("§7无论如何,你想生存.");
        lore.add("§7你想要2件钻石装备.");
        return lore;
    }

    public int unlockCost() {
        return 5000;
    }

    public int energyMelee() {
        return 10;
    }

    public int energyBow() {
        return 10;
    }
}
