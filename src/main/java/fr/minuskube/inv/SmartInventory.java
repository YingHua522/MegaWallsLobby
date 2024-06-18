package fr.minuskube.inv;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryContents.Impl;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.opener.InventoryOpener;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SmartInventory {
    private String id;
    private String title;
    private InventoryType type;
    private int rows;
    private int columns;
    private boolean closeable;
    private InventoryProvider provider;
    private SmartInventory parent;
    private List<InventoryListener<? extends Event>> listeners;
    private InventoryManager manager;

    private SmartInventory(InventoryManager manager) {
        this.manager = manager;
    }

    public static SmartInventory.Builder builder() {
        return new SmartInventory.Builder();
    }

    public Inventory open(Player player) {
        return this.open(player, 0);
    }

    public Inventory open(Player player, int page) {
        Optional<SmartInventory> oldInv = this.manager.getInventory(player);
        oldInv.ifPresent((inv) -> {
            inv.getListeners().stream().filter((listener) -> {
                return listener.getType() == InventoryCloseEvent.class;
            }).forEach((listener) -> {
                listener.accept(new InventoryCloseEvent(player.getOpenInventory()));
            });
            this.manager.setInventory(player, (SmartInventory) null);
        });
        InventoryContents contents = new Impl(this, player);
        contents.pagination().page(page);
        this.manager.setContents(player, contents);
        this.provider.init(player, contents);
        InventoryOpener opener = (InventoryOpener) this.manager.findOpener(this.type).orElseThrow(() -> {
            return new IllegalStateException("No opener found for the inventory type " + this.type.name());
        });
        Inventory handle = opener.open(this, player);
        this.manager.setInventory(player, this);
        return handle;
    }

    public void close(Player player) {
        this.listeners.stream().filter((listener) -> {
            return listener.getType() == InventoryCloseEvent.class;
        }).forEach((listener) -> {
            listener.accept(new InventoryCloseEvent(player.getOpenInventory()));
        });
        this.manager.setInventory(player, (SmartInventory) null);
        player.closeInventory();
        this.manager.setContents(player, (InventoryContents) null);
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public InventoryType getType() {
        return this.type;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public boolean isCloseable() {
        return this.closeable;
    }

    public void setCloseable(boolean closeable) {
        this.closeable = closeable;
    }

    public InventoryProvider getProvider() {
        return this.provider;
    }

    public Optional<SmartInventory> getParent() {
        return Optional.ofNullable(this.parent);
    }

    public InventoryManager getManager() {
        return this.manager;
    }

    List<InventoryListener<? extends Event>> getListeners() {
        return this.listeners;
    }

    public static final class Builder {
        private String id;
        private String title;
        private InventoryType type;
        private int rows;
        private int columns;
        private boolean closeable;
        private InventoryManager manager;
        private InventoryProvider provider;
        private SmartInventory parent;
        private List<InventoryListener<? extends Event>> listeners;

        private Builder() {
            this.id = "unknown";
            this.title = "";
            this.type = InventoryType.CHEST;
            this.rows = 6;
            this.columns = 9;
            this.closeable = true;
            this.listeners = new ArrayList();
        }

        public SmartInventory.Builder id(String id) {
            this.id = id;
            return this;
        }

        public SmartInventory.Builder title(String title) {
            this.title = title;
            return this;
        }

        public SmartInventory.Builder type(InventoryType type) {
            this.type = type;
            return this;
        }

        public SmartInventory.Builder size(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            return this;
        }

        public SmartInventory.Builder closeable(boolean closeable) {
            this.closeable = closeable;
            return this;
        }

        public SmartInventory.Builder provider(InventoryProvider provider) {
            this.provider = provider;
            return this;
        }

        public SmartInventory.Builder parent(SmartInventory parent) {
            this.parent = parent;
            return this;
        }

        public SmartInventory getParent() {
            return this.parent;
        }

        public SmartInventory.Builder listener(InventoryListener<? extends Event> listener) {
            this.listeners.add(listener);
            return this;
        }

        public SmartInventory.Builder manager(InventoryManager manager) {
            this.manager = manager;
            return this;
        }

        public SmartInventory build() {
            if (this.provider == null) {
                throw new IllegalStateException("The provider of the SmartInventory.Builder must be set.");
            } else {
                InventoryManager manager = this.manager != null ? this.manager : MegaWallsLobby.getInstance().getInventoryManager();
                if (manager == null) {
                    throw new IllegalStateException("The manager of the SmartInventory.Builder must be set, or the SmartInvs should be loaded as a plugin.");
                } else {
                    SmartInventory inv = new SmartInventory(manager);
                    inv.id = this.id;
                    inv.title = this.title;
                    inv.type = this.type;
                    inv.rows = this.rows;
                    inv.columns = this.columns;
                    inv.closeable = this.closeable;
                    inv.provider = this.provider;
                    inv.parent = this.parent;
                    inv.listeners = this.listeners;
                    return inv;
                }
            }
        }
    }
}
