package cn.infnetwork.megawallslobby.inventory;

import fr.minuskube.inv.SmartInventory;

public class InventoryManager {
    public static SmartInventory SHOPMENU = null;
    public static SmartInventory CLASSESCONTAINER = null;
    public static SmartInventory UNLOCKCLASSES_NORMAL = null;
    public static SmartInventory UNLOCKCLASSES_MYTHIC = null;
    public static SmartInventory MYTHICDUSTSHOP = null;
    public static SmartInventory EFFECTMENU = null;
    public static SmartInventory EFFECTMENU_HOLOGRAMEFFECT = null;
    public static SmartInventory EFFECTMENU_KILLMESSAGE = null;
    public static SmartInventory TASKMENU = null;
    public static SmartInventory MATCHSERVERMENU = null;
    public static SmartInventory SKINMENU = null;

    public InventoryManager() {
    }

    public static void registerAll() {
        SHOPMENU = ShopMenu.build();
        SKINMENU = Skin.build();
        CLASSESCONTAINER = ClassesContainer.build();
        UNLOCKCLASSES_NORMAL = UnlockClassesMenu.buildNormal();
        UNLOCKCLASSES_MYTHIC = UnlockClassesMenu.buildMythic();
        MYTHICDUSTSHOP = MythicDustShop.build();
        EFFECTMENU = EffectMenu.build();
        EFFECTMENU_HOLOGRAMEFFECT = EffectMenu.buildHologramEffect();
        EFFECTMENU_KILLMESSAGE = EffectMenu.buildKillMessage();
        TASKMENU = TaskMenu.build();
        MATCHSERVERMENU = MatchServerMenu.buildMain();
    }
}
