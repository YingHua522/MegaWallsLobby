package cn.infnetwork.megawallslobby.listener;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import org.bukkit.event.Listener;

public abstract class BaseListener implements Listener {
    private final MegaWallsLobby plugin;

    public BaseListener(MegaWallsLobby plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public MegaWallsLobby getPlugin() {
        return this.plugin;
    }
}
