package cn.infnetwork.megawallslobby.classes.novice.random;

import cn.infnetwork.megawallslobby.classes.Classes;
import cn.infnetwork.megawallslobby.classes.ClassesInfo;
import cn.infnetwork.megawallslobby.classes.ClassesType;
import cn.infnetwork.megawallslobby.classes.EquipmentPackage;
import cn.infnetwork.megawallslobby.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Random extends Classes {
    public Random() {
        super("Random", "随机", ChatColor.DARK_PURPLE, Material.FEATHER, (byte) 0, ClassesType.NOVICE, ClassesInfo.Orientation.values(), ClassesInfo.Difficulty.FOUR);
        setEquipmentPackage(new EquipmentPackage(this) {
            @Override
            public List<ItemStack> getEquipments(int var1) {
                ArrayList<ItemStack> items = new ArrayList<>();
                items.add(new ItemBuilder(Material.BOW).setDisplayName(nameColor + getDisplayName() + " 弓").build());
                return items;
            }

            @Override
            public List<String> getInfo(int var1) {
                return null;
            }
        });
    }

    @Override
    public List<String> getInfo() {
        List<String> lore = new ArrayList<>();
        lore.add("§a随机选择一个职业");
        lore.add(" ");

        lore.add("§a本局获得§6硬币§bx2");
        return lore;
    }

    @Override
    public int unlockCost() {
        return 0;
    }
}
