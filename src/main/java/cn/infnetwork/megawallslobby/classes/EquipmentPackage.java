package cn.infnetwork.megawallslobby.classes;

import cn.infnetwork.megawallslobby.game.GamePlayer;
import cn.infnetwork.megawallslobby.stats.KitStatsContainer;
import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class EquipmentPackage implements Upgradeable {
    private Classes classes;

    public EquipmentPackage(Classes classes) {
        this.classes = classes;
    }

    public String getName() {
        return "职业套装";
    }

    public int maxedLevel() {
        return 5;
    }

    public double getAttribute(int level) {
        return 0.0D;
    }

    public void upgrade(GamePlayer gamePlayer) {
        KitStatsContainer kitStats = gamePlayer.getPlayerStats().getKitStats(this.getClasses());
        kitStats.addEquipLevel();
        kitStats.updateInventory((JsonObject) null);
    }

    public int getPlayerLevel(GamePlayer gamePlayer) {
        return gamePlayer.getPlayerStats().getKitStats(this.getClasses()).getEquipLevel();
    }

    public Material getIconType() {
        return this.getClasses().getIconType();
    }

    public byte getIconData() {
        return this.getClasses().getIconData();
    }

    public int getCost(int level) {
        switch (level) {
            case 2:
                return 500;
            case 3:
                return 2000;
            case 4:
                return 7000;
            case 5:
                return 15000;
            default:
                return 999999;
        }
    }

    public abstract List<ItemStack> getEquipments(int var1);

    public Classes getClasses() {
        return this.classes;
    }
}
