package fr.minuskube.inv.content;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.SlotIterator.Type;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface InventoryContents {
    SmartInventory inventory();

    Pagination pagination();

    Optional<SlotIterator> iterator(String var1);

    SlotIterator newIterator(String var1, Type var2, int var3, int var4);

    SlotIterator newIterator(Type var1, int var2, int var3);

    SlotIterator newIterator(String var1, Type var2, SlotPos var3);

    SlotIterator newIterator(Type var1, SlotPos var2);

    ClickableItem[][] all();

    Optional<SlotPos> firstEmpty();

    Optional<ClickableItem> get(int var1, int var2);

    Optional<ClickableItem> get(SlotPos var1);

    InventoryContents set(int row, int colunms, ClickableItem var3);

    InventoryContents set(SlotPos slotPos, ClickableItem clickableItem);

    InventoryContents add(ClickableItem clickableItem);

    InventoryContents fill(ClickableItem clickableItem);

    InventoryContents fillRow(int var1, ClickableItem var2);

    InventoryContents fillColumn(int var1, ClickableItem var2);

    InventoryContents fillBorders(ClickableItem var1);

    InventoryContents fillRect(int var1, int var2, int var3, int var4, ClickableItem var5);

    InventoryContents fillRect(SlotPos var1, SlotPos var2, ClickableItem var3);

    <T> T property(String var1);

    <T> T property(String var1, T var2);

    InventoryContents setProperty(String var1, Object var2);

    public static class Impl implements InventoryContents {
        private SmartInventory inv;
        private Player player;
        private ClickableItem[][] contents;
        private Pagination pagination = new fr.minuskube.inv.content.Pagination.Impl();
        private Map<String, SlotIterator> iterators = new HashMap();
        private Map<String, Object> properties = new HashMap();

        public Impl(SmartInventory inv, Player player) {
            this.inv = inv;
            this.player = player;
            this.contents = new ClickableItem[inv.getRows()][inv.getColumns()];
        }

        public SmartInventory inventory() {
            return this.inv;
        }

        public Pagination pagination() {
            return this.pagination;
        }

        public Optional<SlotIterator> iterator(String id) {
            return Optional.ofNullable(this.iterators.get(id));
        }

        public SlotIterator newIterator(String id, Type type, int startRow, int startColumn) {
            SlotIterator iterator = new fr.minuskube.inv.content.SlotIterator.Impl(this, this.inv, type, startRow, startColumn);
            this.iterators.put(id, iterator);
            return iterator;
        }

        public SlotIterator newIterator(String id, Type type, SlotPos startPos) {
            return this.newIterator(id, type, startPos.getRow(), startPos.getColumn());
        }

        public SlotIterator newIterator(Type type, int startRow, int startColumn) {
            return new fr.minuskube.inv.content.SlotIterator.Impl(this, this.inv, type, startRow, startColumn);
        }

        public SlotIterator newIterator(Type type, SlotPos startPos) {
            return this.newIterator(type, startPos.getRow(), startPos.getColumn());
        }

        public ClickableItem[][] all() {
            return this.contents;
        }

        public Optional<SlotPos> firstEmpty() {
            for (int row = 0; row < this.contents.length; ++row) {
                for (int column = 0; column < this.contents[0].length; ++column) {
                    if (!this.get(row, column).isPresent()) {
                        return Optional.of(new SlotPos(row, column));
                    }
                }
            }

            return Optional.empty();
        }

        public Optional<ClickableItem> get(int row, int column) {
            if (row >= this.contents.length) {
                return Optional.empty();
            } else {
                return column >= this.contents[row].length ? Optional.empty() : Optional.ofNullable(this.contents[row][column]);
            }
        }

        public Optional<ClickableItem> get(SlotPos slotPos) {
            return this.get(slotPos.getRow(), slotPos.getColumn());
        }

        public InventoryContents set(int row, int column, ClickableItem item) {
            if (row >= this.contents.length) {
                return this;
            } else if (column >= this.contents[row].length) {
                return this;
            } else {
                this.contents[row][column] = item;
                this.update(row, column, item != null ? item.getItem() : null);
                return this;
            }
        }

        public InventoryContents set(SlotPos slotPos, ClickableItem item) {
            return this.set(slotPos.getRow(), slotPos.getColumn(), item);
        }

        public InventoryContents add(ClickableItem item) {
            for (int row = 0; row < this.contents.length; ++row) {
                for (int column = 0; column < this.contents[0].length; ++column) {
                    if (this.contents[row][column] == null) {
                        this.set(row, column, item);
                        return this;
                    }
                }
            }

            return this;
        }

        public InventoryContents fill(ClickableItem item) {
            for (int row = 0; row < this.contents.length; ++row) {
                for (int column = 0; column < this.contents[row].length; ++column) {
                    this.set(row, column, item);
                }
            }

            return this;
        }

        public InventoryContents fillRow(int row, ClickableItem item) {
            if (row >= this.contents.length) {
                return this;
            } else {
                for (int column = 0; column < this.contents[row].length; ++column) {
                    this.set(row, column, item);
                }

                return this;
            }
        }

        public InventoryContents fillColumn(int column, ClickableItem item) {
            for (int row = 0; row < this.contents.length; ++row) {
                this.set(row, column, item);
            }

            return this;
        }

        public InventoryContents fillBorders(ClickableItem item) {
            this.fillRect(0, 0, this.inv.getRows() - 1, this.inv.getColumns() - 1, item);
            return this;
        }

        public InventoryContents fillRect(int fromRow, int fromColumn, int toRow, int toColumn, ClickableItem item) {
            for (int row = fromRow; row <= toRow; ++row) {
                for (int column = fromColumn; column <= toColumn; ++column) {
                    if (row == fromRow || row == toRow || column == fromColumn || column == toColumn) {
                        this.set(row, column, item);
                    }
                }
            }

            return this;
        }

        public InventoryContents fillRect(SlotPos fromPos, SlotPos toPos, ClickableItem item) {
            return this.fillRect(fromPos.getRow(), fromPos.getColumn(), toPos.getRow(), toPos.getColumn(), item);
        }

        public <T> T property(String name) {
            return (T) this.properties.get(name);
        }

        public <T> T property(String name, T def) {
            return this.properties.containsKey(name) ? (T) this.properties.get(name) : def;
        }

        public InventoryContents setProperty(String name, Object value) {
            this.properties.put(name, value);
            return this;
        }

        private void update(int row, int column, ItemStack item) {
            if (this.inv.getManager().getOpenedPlayers(this.inv).contains(this.player)) {
                Inventory topInventory = this.player.getOpenInventory().getTopInventory();
                topInventory.setItem(this.inv.getColumns() * row + column, item);
            }
        }
    }
}
