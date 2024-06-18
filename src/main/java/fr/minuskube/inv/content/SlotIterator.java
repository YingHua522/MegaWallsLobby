package fr.minuskube.inv.content;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public interface SlotIterator {
    Optional<ClickableItem> get();

    SlotIterator set(ClickableItem var1);

    SlotIterator previous();

    SlotIterator next();

    SlotIterator blacklist(int var1, int var2);

    SlotIterator blacklist(SlotPos var1);

    int row();

    SlotIterator row(int var1);

    int column();

    SlotIterator column(int var1);

    boolean started();

    boolean ended();

    boolean doesAllowOverride();

    SlotIterator allowOverride(boolean var1);

    public static enum Type {
        HORIZONTAL,
        VERTICAL;

        private Type() {
        }
    }

    public static class Impl implements SlotIterator {
        private InventoryContents contents;
        private SmartInventory inv;
        private SlotIterator.Type type;
        private boolean started;
        private boolean allowOverride;
        private int row;
        private int column;
        private Set<SlotPos> blacklisted;

        public Impl(InventoryContents contents, SmartInventory inv, SlotIterator.Type type, int startRow, int startColumn) {
            this.started = false;
            this.allowOverride = true;
            this.blacklisted = new HashSet();
            this.contents = contents;
            this.inv = inv;
            this.type = type;
            this.row = startRow;
            this.column = startColumn;
        }

        public Impl(InventoryContents contents, SmartInventory inv, SlotIterator.Type type) {
            this(contents, inv, type, 0, 0);
        }

        public Optional<ClickableItem> get() {
            return this.contents.get(this.row, this.column);
        }

        public SlotIterator set(ClickableItem item) {
            if (this.canPlace()) {
                this.contents.set(this.row, this.column, item);
            }

            return this;
        }

        public SlotIterator previous() {
            if (this.row == 0 && this.column == 0) {
                this.started = true;
                return this;
            } else {
                do {
                    if (!this.started) {
                        this.started = true;
                    } else {
                        switch (this.type) {
                            case HORIZONTAL:
                                --this.column;
                                if (this.column == 0) {
                                    this.column = this.inv.getColumns() - 1;
                                    --this.row;
                                }
                                break;
                            case VERTICAL:
                                --this.row;
                                if (this.row == 0) {
                                    this.row = this.inv.getRows() - 1;
                                    --this.column;
                                }
                        }
                    }
                } while (!this.canPlace() && (this.row != 0 || this.column != 0));

                return this;
            }
        }

        public SlotIterator next() {
            if (this.ended()) {
                this.started = true;
                return this;
            } else {
                do {
                    if (!this.started) {
                        this.started = true;
                    } else {
                        switch (this.type) {
                            case HORIZONTAL:
                                this.column = ++this.column % this.inv.getColumns();
                                if (this.column == 0) {
                                    ++this.row;
                                }
                                break;
                            case VERTICAL:
                                this.row = ++this.row % this.inv.getRows();
                                if (this.row == 0) {
                                    ++this.column;
                                }
                        }
                    }
                } while (!this.canPlace() && !this.ended());

                return this;
            }
        }

        public SlotIterator blacklist(int row, int column) {
            this.blacklisted.add(SlotPos.of(row, column));
            return this;
        }

        public SlotIterator blacklist(SlotPos slotPos) {
            return this.blacklist(slotPos.getRow(), slotPos.getColumn());
        }

        public int row() {
            return this.row;
        }

        public SlotIterator row(int row) {
            this.row = row;
            return this;
        }

        public int column() {
            return this.column;
        }

        public SlotIterator column(int column) {
            this.column = column;
            return this;
        }

        public boolean started() {
            return this.started;
        }

        public boolean ended() {
            return this.row == this.inv.getRows() - 1 && this.column == this.inv.getColumns() - 1;
        }

        public boolean doesAllowOverride() {
            return this.allowOverride;
        }

        public SlotIterator allowOverride(boolean override) {
            this.allowOverride = override;
            return this;
        }

        private boolean canPlace() {
            return !this.blacklisted.contains(SlotPos.of(this.row, this.column)) && (this.allowOverride || !this.get().isPresent());
        }
    }
}
