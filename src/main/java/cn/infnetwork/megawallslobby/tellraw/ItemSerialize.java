package cn.infnetwork.megawallslobby.tellraw;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ItemSerialize {
    static ItemSerialize itemSerialize;

    static {
        try {
            itemSerialize = new ItemSerialize.Automatic();
        } catch (IllegalStateException var1) {
            itemSerialize = new ItemSerialize.Manual();
        }

    }

    public ItemSerialize() {
    }

    public static String $(ItemStack item) {
        return itemSerialize.parse(item);
    }

    public abstract String parse(ItemStack var1);

    public abstract String getName();

    static class Manual extends ItemSerialize {
        Manual() {
        }

        public String getName() {
            return "Manual";
        }

        public String parse(ItemStack item) {
            return this.serialize(item);
        }

        private String getDisplay(ItemMeta im) {
            StringBuilder display = new StringBuilder();
            display.append("{");
            if (im.hasDisplayName()) {
                display.append(String.format("Name:\"%s\",", im.getDisplayName()));
            }

            if (im.hasLore()) {
                display.append("Lore:[");
                int i = 0;

                for (Iterator var4 = im.getLore().iterator(); var4.hasNext(); ++i) {
                    String line = (String) var4.next();
                    display.append(String.format("%s:\"%s\",", i, (new JsonBuilder(line)).toString()));
                }

                display.deleteCharAt(display.length() - 1);
                display.append("],");
            }

            display.deleteCharAt(display.length() - 1);
            display.append("}");
            return display.toString();
        }

        private String getEnch(Set<Entry<Enchantment, Integer>> set) {
            StringBuilder enchs = new StringBuilder();
            Iterator var3 = set.iterator();

            while (var3.hasNext()) {
                Entry<Enchantment, Integer> ench = (Entry) var3.next();
                enchs.append(String.format("{id:%s,lvl:%s},", ((Enchantment) ench.getKey()).getId(), ench.getValue()));
            }

            enchs.deleteCharAt(enchs.length() - 1);
            return enchs.toString();
        }

        private String getTag(ItemMeta im) {
            StringBuilder meta = new StringBuilder("{");
            if (im.hasEnchants()) {
                meta.append(String.format("ench:[%s],", this.getEnch(im.getEnchants().entrySet())));
            }

            if (im.hasDisplayName() || im.hasLore()) {
                meta.append(String.format("display:%s,", this.getDisplay(im)));
            }

            meta.deleteCharAt(meta.length() - 1);
            meta.append("}");
            return meta.toString();
        }

        private String serialize(ItemStack item) {
            StringBuilder json = new StringBuilder("{");
            json.append(String.format("id:\"%s\",Damage:\"%s\"", item.getTypeId(), item.getDurability()));
            if (item.getAmount() > 1) {
                json.append(String.format(",Count:%s", item.getAmount()));
            }

            if (item.hasItemMeta()) {
                json.append(String.format(",tag:%s", this.getTag(item.getItemMeta())));
            }

            json.append("}");
            return json.toString();
        }
    }

    static class Automatic extends ItemSerialize {
        private static boolean inited = false;
        private static Method asNMSCopyMethod;
        private static Method nmsSaveNBTMethod;
        private static Class<?> nmsNBTTagCompound;
        private static String ver = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];

        static {
            try {
                Class<?> cis = getOBCClass("inventory.CraftItemStack");
                asNMSCopyMethod = cis.getMethod("asNMSCopy", ItemStack.class);
                Class<?> nmsItemStack = asNMSCopyMethod.getReturnType();
                Method[] var2 = nmsItemStack.getMethods();
                int var3 = var2.length;

                int var4;
                Method method;
                for (var4 = 0; var4 < var3; ++var4) {
                    method = var2[var4];
                    Class<?> rt = method.getReturnType();
                    if (method.getParameterTypes().length == 0 && "NBTTagCompound".equals(rt.getSimpleName())) {
                        nmsNBTTagCompound = rt;
                    }
                }

                var2 = nmsItemStack.getMethods();
                var3 = var2.length;

                for (var4 = 0; var4 < var3; ++var4) {
                    method = var2[var4];
                    Class<?>[] paras = method.getParameterTypes();
                    Class<?> rt = method.getReturnType();
                    if (paras.length == 1 && "NBTTagCompound".equals(paras[0].getSimpleName()) && "NBTTagCompound".equals(rt.getSimpleName())) {
                        nmsSaveNBTMethod = method;
                    }
                }

                inited = true;
            } catch (NoSuchMethodException | ClassNotFoundException var8) {
                var8.printStackTrace();
            }

        }

        public Automatic() {
            if (!inited) {
                throw new IllegalStateException("无法初始化自动处理类!");
            }
        }

        private static Class getOBCClass(String cname) throws ClassNotFoundException {
            return Class.forName("org.bukkit.craftbukkit." + ver + "." + cname);
        }

        public String getName() {
            return "Automatic";
        }

        public String parse(ItemStack item) {
            try {
                return nmsSaveNBTMethod.invoke(asNMSCopyMethod.invoke(null, item), nmsNBTTagCompound.newInstance()).toString();
            } catch (IllegalArgumentException | InvocationTargetException | InstantiationException |
                     IllegalAccessException var3) {
                itemSerialize = new ItemSerialize.Manual();
                return itemSerialize.parse(item);
            }
        }
    }
}
