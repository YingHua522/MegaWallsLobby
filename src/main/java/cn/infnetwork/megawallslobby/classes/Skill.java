package cn.infnetwork.megawallslobby.classes;

import org.bukkit.Material;

public abstract class Skill implements Upgradeable {
    private String name;
    private Classes classes;

    public Skill(String name, Classes classes) {
        this.name = name;
        this.classes = classes;
    }

    public Material getIconType() {
        return this.getClasses().getIconType();
    }

    public byte getIconData() {
        return this.getClasses().getIconData();
    }

    public int getCost(int level) {
        if (this.maxedLevel() == 5) {
            switch (level) {
                case 2:
                    return 1000;
                case 3:
                    return 2000;
                case 4:
                    return 4000;
                case 5:
                    return 7500;
                default:
                    return 999999;
            }
        } else {
            switch (level) {
                case 2:
                    return 2000;
                case 3:
                    return 5000;
                default:
                    return 999999;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Classes getClasses() {
        return this.classes;
    }
}
