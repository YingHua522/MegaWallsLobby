package cn.infnetwork.megawallslobby.hologram;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedDataManager;
import org.bukkit.Bukkit;

public class ResultLine {
    private int rank;
    private String name;
    private int value;

    public ResultLine(int rank, String name, int value) {
        this.rank = rank;
        this.name = name;
        this.value = value;
    }

    public static String getColor(String name) {
//        System.out.println(name);
        CachedDataManager cachedData = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getOfflinePlayer(name).getUniqueId()).getCachedData();
        if (cachedData == null) return "§7";
        String prefix = cachedData.getMetaData(LuckPermsProvider.get().getContextManager().getStaticQueryOptions()).getPrefix();
        if (prefix == null) return "§7";
        if (prefix.contains("志愿者")) {
            return "§9";
        } else if (prefix.contains("客服")) {
            return "§2";
        } else if (prefix.contains("铁锭")) {
            return "§f";
        } else if (prefix.contains("金锭")) {
            return "§e";
        } else if (prefix.contains("绿宝石")) {
            return "§a";
        } else if (prefix.contains("管理")) {
            return "§c";
        } else if (prefix.contains("开发者")) {
            return "§b";
        } else if (prefix.contains("志愿者")) {
            return "§b";
        } else if (prefix.contains("建") && prefix.contains("筑")) {
            return "§6";
        }
        return "§7";
    }

    public int getRank() {
        return this.rank;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
