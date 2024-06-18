package fr.minuskube.inv;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class ClickableItem {
    private ItemStack item;
    private Consumer<InventoryClickEvent> consumer;
    private boolean cancel;

    private ClickableItem(ItemStack item, Consumer<InventoryClickEvent> consumer, boolean cancel) {
        this.item = item;
        this.consumer = consumer;
        this.cancel = cancel;
    }

    public static ClickableItem empty(ItemStack item) {
        return of(item, (e) -> {
        });
    }

    public static ClickableItem of(ItemStack item, Consumer<InventoryClickEvent> consumer) {
        return new ClickableItem(item, consumer, true);
    }

    public static ClickableItem of(ItemStack item, Consumer<InventoryClickEvent> consumer, boolean cancel) {
        return new ClickableItem(item, consumer, cancel);
    }

    public void run(InventoryClickEvent e) {
        this.consumer.accept(e);
    }

    public ItemStack getItem() {
        return this.item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public boolean isCancel() {
        return this.cancel;
    }
}
