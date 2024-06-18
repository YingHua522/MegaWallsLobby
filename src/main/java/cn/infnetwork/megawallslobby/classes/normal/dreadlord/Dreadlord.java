package cn.infnetwork.megawallslobby.classes.normal.dreadlord;

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

public class Dreadlord extends Classes {
    public Dreadlord() {
        super("Dreadlord", "恐惧魔王", ChatColor.DARK_RED, Material.NETHER_BRICK_ITEM, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.CHARGER, Orientation.WARRIOR}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0MzU3NjUxMTQsInByb2ZpbGVJZCI6ImUzYjQ0NWM4NDdmNTQ4ZmI4YzhmYTNmMWY3ZWZiYThlIiwicHJvZmlsZU5hbWUiOiJNaW5pRGlnZ2VyVGVzdCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM1ZGUxZGM0NzQ5ZTAwODQ4MDc2NjQyYzNlYTBhODgyZWYzZGQwZWI3NDIxZGZmMzBhNWI2OTI0MmU0ZjI1MCJ9fX0=", "oqpCDV79FQguuos7pUQy1KoQVqbpPnkLp1FmOG6rCcofYT4kbl4q07Eb6gfqDQUUXCfXu9kW1kCaHDbJYwJ6LNRbXdZ0WhhBI7wtyfclbexMLRfZH4sNzW8p5yYJWoQn7uWc3Sd5bQpm3zu+w6s2d5JXo4YWogFn+GBIkD90lREZMJe0o4uyv/cqKkCbLgpT+Ey7OOxvRbYaTvHGtPlkdUWSNwXWbe/zs0qE7p+OcSHRT7Ww5axHlhb4l1zVBuvMZfaoNoJhdUpLr3CShz6h3iBJcqPgvmjROmmPOrpJ69JE8+JiuYxm0YImmflWBOaxG8JmP9v4tDF4quzNuHwPuR6FKCYYnVsaU3rvzW1V+xgVzM4h4vZlcHrN/tzo0fZyBVhGhXDlYUxRXQ2q2NK2xbH7MlAmsC5PzfmvIlFC+LqLP3gRS7rDvdOwLEV1MV4+FUscf+nYTcPZUXjoXieMVT8h4NNx1FLOiZvAyZwUdx/V858B1K2GXlg7q50VN185bZvy4J2OzzbcLms7DTSGmX9Kv4U4BWChGXb39O1fRFtKqiprjNgikRrsvr/9Xs/BOh3gTC+SGE3SrPHi8Jv2ZSoTcGIB3zOCWwvxbeKdssculhpY/4MLCpMSQyDpyE+ajr4NxKLoq9QgYNuyTSf029WUyN/3+ouG9leZr3sdqao=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_FIRE, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_UNDEAD, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_UNDEAD, 1).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_FIRE, 1).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Dreadlord.this.nameColor + Dreadlord.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7铁 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 火焰保护 I");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add("    §a+ 爆炸保护 I");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add("    §8▪ 爆炸保护 I");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7钻石 剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7钻石 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 火焰保护 I");
                        lore.add("    §8▪ 爆炸保护 I ➜ §aII");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你喜欢近战与远程的混合.");
        lore.add("§7你是方块挖掘高手.");
        lore.add("§7你是一名法师.");
        return lore;
    }

    public int unlockCost() {
        return 15000;
    }

    public int energyMelee() {
        return 13;
    }

    public int energyBow() {
        return 13;
    }
}
