package cn.infnetwork.megawallslobby.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

public class ItemBuilder {
    private ItemStack itemStack;

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemBuilder(Material material, int amount) {
        this.itemStack = new ItemStack(material, amount);
    }

    public ItemBuilder(Material material, int amount, byte durability) {
        this.itemStack = new ItemStack(material, amount, (short) durability);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(this.itemStack);
    }

    public ItemBuilder setDurability(short durability) {
        this.itemStack.setDurability(durability);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.spigot().setUnbreakable(unbreakable);
        this.itemStack.setItemMeta(meta);
        return this;
    }


    public ItemBuilder setSkullSkin(String skinValue) {
        if (this.itemStack.getType() != Material.SKULL_ITEM) {
            throw new IllegalArgumentException("Event item not skull.");
        } else {
            SkullMeta skullMeta = (SkullMeta)this.itemStack.getItemMeta();
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
            profile.getProperties().put("textures", new Property("textures", skinValue));

            try {
                Field field = skullMeta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                field.set(skullMeta, profile);
            } catch (IllegalAccessException | NoSuchFieldException var5) {
                ReflectiveOperationException e = var5;
                e.printStackTrace();
            }

            this.itemStack.setItemMeta(skullMeta);
            return this;
        }
    }

    public ItemBuilder setDisplayName(String name) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment, int level) {
        this.itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner) {
        SkullMeta im = (SkullMeta) this.itemStack.getItemMeta();
        im.setOwner(owner);
        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemBuilder setEnchantMeta(Map<Enchantment, Integer> enchantments) {
        EnchantmentStorageMeta im = (EnchantmentStorageMeta) this.itemStack.getItemMeta();
        Iterator var3 = enchantments.entrySet().iterator();

        while (var3.hasNext()) {
            Entry<Enchantment, Integer> m = (Entry) var3.next();
            im.addStoredEnchant((Enchantment) m.getKey(), (Integer) m.getValue(), true);
        }

        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        ItemMeta im = this.itemStack.getItemMeta();
        im.addEnchant(enchantment, level, true);
        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemBuilder setInfinityDurability() {
        this.itemStack.setDurability((short) 32767);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        ItemMeta im = this.itemStack.getItemMeta();
        List<String> lores = new ArrayList();
        String[] var4 = lore;
        int var5 = lore.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            String line = var4[var6];
            lores.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        im.setLore(lores);
        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta im = this.itemStack.getItemMeta();
        List<String> lores = new ArrayList();
        Iterator var4 = lore.iterator();

        while (var4.hasNext()) {
            String line = (String) var4.next();
            lores.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        im.setLore(lores);
        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemBuilder setDyeColor(DyeColor color) {
        this.itemStack.setDurability((short) color.getData());
        return this;
    }

    public ItemBuilder addGlow() {
        ItemMeta im = this.itemStack.getItemMeta();
        im.addEnchant(Enchantment.DURABILITY, 1, true);
        im.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemBuilder addPotion(PotionEffect potionEffect) {
        PotionMeta im = (PotionMeta) this.itemStack.getItemMeta();
        im.addCustomEffect(potionEffect, true);
        this.itemStack.setItemMeta(im);
        return this;
    }

    public ItemStack build() {
        return this.itemStack;
    }
}
