package cn.infnetwork.megawallslobby.classes.mythic.werewolf;

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

public class Werewolf extends Classes {
    public Werewolf() {
        super("Werewolf", "狼人", ChatColor.GREEN, Material.COOKED_BEEF, (byte) 0, ClassesType.MYTHIC, new Orientation[]{Orientation.TANK, Orientation.WARRIOR}, Difficulty.TWO);
        this.setMainSkill(new MainSkill(this));
        this.setSecondSkill(new SecondSkill(this));
        this.setThirdSkill(new ThirdSkill(this));
        this.setCollectSkill(new FourthSkill(this));
        this.setDefaultSkin("eyJ0aW1lc3RhbXAiOjE1NDkyMDIyNjExMTUsInByb2ZpbGVJZCI6ImUzYjQ0NWM4NDdmNTQ4ZmI4YzhmYTNmMWY3ZWZiYThlIiwicHJvZmlsZU5hbWUiOiJNaW5pRGlnZ2VyVGVzdCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzUxNmQwNDVlNzNlYmM1N2RhNDY2YTJmN2I0Mjg4MTU5MWI1OTkwMDEwNmEyOGY4ZmZhMGNiZGFhOGE5MTQ5In19fQ==", "UpX2geR+fVfuG5MTLf5ttJQVUJebckJSxtJk76l3iwtV3ceIPGhFqF1RPC27WY9UmZJmFZde3v8E1bw66Tt7Au5Ol4X/D2YC+tl1gxkLSJUNaG12O03x/od5uohux1OPtgof21UIVgyewh6C5OAVegmRHFnx7obeWyuTboymbIkwIsffkVx0sbzgNaFQkcrSVUQYa4OTZ5Bp4zLpDeRGG9XjlCmurnaGOPHJT8N298TD1qAHEHYAuMZQIEze4RHzux01DH8b8lVA0HW5mN7OS4QjGAMGeUhOLYKptCo2bkem+u0Rc6RxC2h2oPA1yUCf95hG8QUAy/b9qn2Y4B+EnUBwRZjJrojtX7n/QSThGlCegeASyZdehcrUnE5/xAcGhwQh68ympbVQmY4YmxzZfvGe2kxOI8fHFMmrkGQLFXwu+6ceeE9y09gjbujK3VM4hIvWYaBBfFWIX4VIJsrTVT1oIGmpV/jjZbcKXWAOFkG+j87hgqZjBXAPMJZ6uLJS5D/BBR83JjU5a8w0eX1pnMBXwTZae7hd27IQVEoePXnr9Zw4HNsxlpvU5Bclv7aR5mX1OtDH7LI6ktWlYw1v6+B7+X8iAG76zcYHQUQXyyWseZAeKu6KgbCLTCdFKcPH5/ksIRmfENQq/9hItRA3UZCdSgAUTWtV3U9xQkTWT+c=");
        this.setEquipmentPackage(new EquipmentPackage(this) {

            @Override
            public List<ItemStack> getEquipments(int level) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemBuilder(Material.COMPASS).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Compass").build());
                items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Pickaxe").setUnbreakable(true).addEnchantment(Enchantment.DIG_SPEED, 3).addEnchantment(Enchantment.DURABILITY, 3).build());
                items.add(new ItemBuilder(Material.ENDER_CHEST).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Ender Chest").build());
                switch (level) {
                    case 1: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Heal (6❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 1)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Speed II 和 跳跃 V (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 1).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 2: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Heal (6❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 1)).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 2).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Speed II 和 跳跃 V (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 2).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 3: {
                        items.add(new ItemBuilder(Material.IRON_SWORD).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Speed II 和 跳跃 V (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 3).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 4: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Heal (8❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 2, (byte) 2).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Speed II 和 跳跃 V (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 4).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Steak").build());
                        break;
                    }
                    case 5: {
                        items.add(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Sword").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.BOW).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Bow").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Chestplate").setUnbreakable(true).addEnchantment(Enchantment.DURABILITY, 10).build());
                        items.add(new ItemBuilder(Material.POTION, 1, (byte) 5).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Heal (10❤)").addPotion(new PotionEffect(PotionEffectType.HEAL, 1, 2)).build());
                        items.add(new ItemBuilder(Material.POTION, 3, (byte) 2).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Potion of Speed II (0:15s)").addPotion(new PotionEffect(PotionEffectType.SPEED, 300, 1)).addPotion(new PotionEffect(PotionEffectType.JUMP, 300, 4)).build());
                        items.add(new ItemBuilder(Material.COOKED_BEEF, 5).setDisplayName(Werewolf.this.nameColor + Werewolf.this.getDisplayName() + " Steak").build());
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
                        lore.add(" §8▪ §7治疗药水 6❤");
                        lore.add(" §8▪ §7速度药水 II 和 跳跃 V");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排");
                        break;
                    case 2:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §a+ 保护 I");
                        lore.add(" §8▪ §7牛排 §8x1 ➜ §ax2");
                        break;
                    case 3:
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 I ➜ §aII");
                        lore.add(" §8▪ §7治疗药水 6❤ ➜ §a8❤");
                        lore.add(" §8▪ §7速度药水 II 和 跳跃 V §8x1 ➜ §ax2");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x2 ➜ §ax3");
                        break;
                    case 4:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7剑");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7铁 胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add("    §8▪ 保护 II ➜ §aIII");
                        lore.add(" §8▪ §7牛排 §8x3 ➜ §ax4");
                        break;
                    case 5:
                        lore.add(" §8▪ §7铁 §8➜ §a钻石 §7胸甲");
                        lore.add("    §8▪ 耐久 X");
                        lore.add(" §8▪ §7速度药水 II 和 跳跃 V §8x2 ➜ §ax3");
                        lore.add("    §8▪ 0:15");
                        lore.add(" §8▪ §7牛排 §8x4 ➜ §ax5");
                }

                return lore;
            }
        });
    }

    public List<String> getInfo() {
        List<String> lore = new ArrayList();
        lore.add("§7你想要有技能来保证你持续点击左键.");
        lore.add("§7你想要在1v2中取得机会.");
        lore.add("§7有时觉醒,对月长嗥.");
        return lore;
    }

    public int unlockCost() {
        return 3;
    }

    public int energyMelee() {
        return 8;
    }

    public int energyBow() {
        return 6;
    }
}
