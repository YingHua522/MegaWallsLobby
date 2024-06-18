package cn.infnetwork.megawallslobby.classes.normal.hunter;

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

import java.util.ArrayList;
import java.util.List;

public class Hunter extends Classes {
    public Hunter() {
        super("Hunter", "猎人", ChatColor.GREEN, Material.BOW, (byte) 0, ClassesType.NORMAL, new Orientation[]{Orientation.REMOTE, Orientation.WARRIOR}, Difficulty.THREE);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDk0Mzc4MTQ1NzMsInByb2ZpbGVJZCI6ImFkMWM2Yjk1YTA5ODRmNTE4MWJhOTgyMzY0OTllM2JkIiwicHJvZmlsZU5hbWUiOiJGdXJrYW5iejAwIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84NGVlMWYwNjYxMTg5ZmUwY2Q1OTA1ZjlhOTRlNDAyNDBlNWE1YjZiZmY3YjA5M2E1MDc2YzJkZGRmYTZkZDQ2In19fQ==", "XrI4Gs7fKBlZG8VV1+Eg5b8hY9P+I7ugNZe4MjDR+kdQNr8gzsBJvWn9l76gkx64XFA7IW7JT2D8OIDqOhn2X3nbxIm9ug0P+1K3A8pHDf9r9NrgMqKKajTHIz6LscYMfUCwpCJ/G0LWMzXUobxkYZnjNdN5ckHuVL178XGiy8yZ6aUUakGrfdej01O3oThc9YqcDgSpaiqFKzsuUBe1bK9rK1yAu4B4/An/nSoo7DDwehAxFm7RRmrk8eoSUyOgCjicZnp/hJcG+FY3AFs9SwFYn7TzJ+ddh85jSjqLQP+GUSMhtXOBxgWijMAilrew8Rp6WN3bgy241NBCnwYkq7pkf6O/QLBIWdlMALUNu6DuJLHYhl7jOEHLTN/BcyCOLl4Vrh+fqd5GT01yAvUyiMUg+cuEouxz31i3Ss5hley6+v2HIRGUFZpJba7hf7u0376XQukEVSif6FBWqsJMUXRbe04DZLY7gBJo46ZaEqeV0zgD9f4OSN8alUVYNe7ingvDH/mWvz7aDYpzfHditABxC/YH8GtOuypdQrVptSHyyF++Tm+O6EMb6QGQjAYQCzc9AxJvw8s601xOJd9Sd6fxNB2+d6oEnGNeAR52QBeG7EsvnrXLBfwTKQuW52n2/4tXV2AsjatJBg4auBy5oRp+czbJW5DBry3tqvy6AWQ=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Golden Apple").build());
                        items.add(new ItemBuilder(Material.ARROW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_INFINITE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Golden Apple").build());
                        items.add(new ItemBuilder(Material.ARROW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).addEnchantment(Enchantment.ARROW_INFINITE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_HELMET).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.GOLDEN_APPLE, 2).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Golden Apple").build());
                        items.add(new ItemBuilder(Material.ARROW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).addEnchantment(Enchantment.ARROW_INFINITE, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.GOLDEN_APPLE, 2).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Golden Apple").build());
                        items.add(new ItemBuilder(Material.ARROW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.ARROW_DAMAGE, 1).addEnchantment(Enchantment.ARROW_INFINITE, 1).build());
                        items.add(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Helmet").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).build());
                        items.add(new ItemBuilder(Material.IRON_BOOTS).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Boots").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.GOLDEN_APPLE, 5).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Golden Apple").build());
                        items.add(new ItemBuilder(Material.ARROW).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Arrow").build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Steak").build());
                        items.add(new ItemBuilder(Material.CARROT_STICK).setDisplayName(Hunter.this.nameColor + Hunter.this.getDisplayName() + " Carrot Stick").build());
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
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 无限 I");
                        lore.add(" §8▪ §7铁 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7金苹果");
                        lore.add(" §8▪ §7箭");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 弹射物保护 I");
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7弓");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 力量 I");
                        lore.add("    §8▪ 无限 I");
                        lore.add(" §8▪ §7铁 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add("    §8▪ 弹射物保护 I");
                        lore.add(" §8▪ §7金苹果 §8x1 ➜ §ax2");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I");
                        lore.add("    §8▪ 弹射物保护 I");
                        lore.add(" §8▪ §7铁 靴子");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 锋利 I");
                        lore.add(" §8▪ §7钻石 头盔");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add("    §8▪ 弹射物保护 I ➜ §aII");
                        lore.add(" §8▪ §7金苹果 §8x2 ➜ §ax3");
                        lore.add(" §a+ §7胡萝卜钓竿");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你喜欢精准箭法.");
        lore.add("§7你想要一些小宠物来帮助你.");
        lore.add("§7你想拥有夜视能力.");
        return lore;
    }

    public int unlockCost() {
        return 40000;
    }

    public int energyMelee() {
        return 4;
    }

    public int energyBow() {
        return 8;
    }
}
