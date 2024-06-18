package cn.infnetwork.megawallslobby.game;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

public enum TeamColor {
    GREEN(Color.fromRGB(85, 255, 85), ChatColor.GREEN, DyeColor.GREEN, "绿"),
    RED(Color.fromRGB(255, 85, 85), ChatColor.RED, DyeColor.RED, "红"),
    BLUE(Color.fromRGB(85, 85, 255), ChatColor.BLUE, DyeColor.LIGHT_BLUE, "蓝"),
    YELLOW(Color.fromRGB(255, 255, 85), ChatColor.YELLOW, DyeColor.YELLOW, "黄");

    private Color color;
    private ChatColor chatColor;
    private DyeColor dyeColor;
    private String text;

    private TeamColor(Color color, ChatColor chatColor, DyeColor dyeColor, String text) {
        this.chatColor = chatColor;
        this.color = color;
        this.dyeColor = dyeColor;
        this.text = text;
    }

    public String getChatPrefix() {
        return this.getChatColor() + "[" + this.getText() + "色]";
    }

    public String getTag() {
        return "[" + this.getText() + "]";
    }

    public Color getColor() {
        return this.color;
    }

    public ChatColor getChatColor() {
        return this.chatColor;
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public String getText() {
        return this.text;
    }
}
