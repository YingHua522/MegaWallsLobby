package cn.infnetwork.megawallslobby.classes.normal.spider;

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

public class Spider extends Classes {
    public Spider() {
        super("Spider", "蜘蛛", ChatColor.DARK_PURPLE, Material.WEB, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.AGILITY, Orientation.CHARGER}, Difficulty.THREE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0Mzc4MjcwMzgsInByb2ZpbGVJZCI6IjkxZjA0ZmU5MGYzNjQzYjU4ZjIwZTMzNzVmODZkMzllIiwicHJvZmlsZU5hbWUiOiJTdG9ybVN0b3JteSIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTMwOTliZWRlZTE3Y2JhMzA3ODU3MmQzMjM3NWE1YTRmYjgwMjZiMzA1ZmViM2IwZGExNTMzYjdkNmEyZDlhYyJ9fX0=", "j2Cu6xMoeD4a0BURXPtMu801DioMRj/Onw2vr9+fpT8CX9w7ztz7zGGl2Pb4jWTWuqW7GEvbivWA6G4UWMpxdLHnmmOqkRa2U3N3uAw+YUYAji2Q086HIkaHZTVCmDkxskrySnUuOaN71ck+TD+qS6cJS3AeAvMd/cwKyEricS5GbTssbms5X7hL58s7j9Rb42i3MUl3B0oo++l2vxDe0q3f0NB1K6YlpnnHNgvZKRww9KPk2iUbqrDNZFHX7xIfndAYrvQvUATyQqAAeaDdi2VxoocMOKdfNvTey6g4OD4YyrK62shYV8xD8p+DVU1NjtPSJlyBu9s9vxej9mFxGpct8VndHvntzWID64cWT/dzK9PyMUmRhoPQejVZ8n1+Xl/QzHIyPvT8mjHMmdW+eHmh/eqXCLK4OkRWL8CO9yUMgDktVC/reFR8rveiqoPMkdeV6CN3gGOfgmPdtWbemoytNY0q7MbWfrBuSqpv6q1lL1eA4I/ODH5DJE+EFrfA4QRLakArKtD+sw+gWtp2IwQqtN6X6rGLAbEw6M84wrZ0gNmB1Kz9OLO/Lw193nvTXaHWpiO0/NXdES8OJX96wGlQcpaRUo5v0QnsbEvHbG7SJkDP8gN5aX2FnO+S96XBuFm02cCj7TXF8NRH2WfHj3c99wXNX5kFZ+8l+IxW3Ys=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_SPADE).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Spade").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_SPADE).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Spade").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_SPADE).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Spade").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_SPADE).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Spade").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 4).build());
                        items.add(new ItemBuilder(Material.IRON_SPADE).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Shovel").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 5).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Heal (8\u2764)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Spider.this.nameColor + Spider.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
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
                        lore.add(" §8▪ §7治疗药水 8❤");
                        lore.add(" §8▪ §7铁 锹");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 效率 I");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §a+ §7速度药水 II");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7速度药水 §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7治疗药水 8❤ §8x1 ➜ §ax2");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 节肢杀手 IV");
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
        lore.add("§7你喜欢伏击落单的敌人.");
        lore.add("§7你喜欢在高空作战.");
        lore.add("§7你不怕蜘蛛.");
        return lore;
    }

    public int unlockCost() {
        return 15000;
    }

    public int energyMelee() {
        return 8;
    }

    public int energyBow() {
        return 8;
    }
}
