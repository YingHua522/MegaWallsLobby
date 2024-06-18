package fr.minuskube.inv.content;

import fr.minuskube.inv.ClickableItem;

import java.util.Arrays;

public interface Pagination {
    ClickableItem[] getPageItems();

    int getPage();

    Pagination page(int var1);

    boolean isFirst();

    boolean isLast();

    Pagination first();

    Pagination previous();

    Pagination next();

    Pagination last();

    Pagination addToIterator(SlotIterator var1);

    Pagination setItems(ClickableItem... var1);

    Pagination setItemsPerPage(int var1);

    public static class Impl implements Pagination {
        private int currentPage;
        private ClickableItem[] items = new ClickableItem[0];
        private int itemsPerPage = 5;

        public Impl() {
        }

        public ClickableItem[] getPageItems() {
            return (ClickableItem[]) Arrays.copyOfRange(this.items, this.currentPage * this.itemsPerPage, (this.currentPage + 1) * this.itemsPerPage);
        }

        public int getPage() {
            return this.currentPage;
        }

        public Pagination page(int page) {
            this.currentPage = page;
            return this;
        }

        public boolean isFirst() {
            return this.currentPage == 0;
        }

        public boolean isLast() {
            return this.currentPage == this.items.length / this.itemsPerPage;
        }

        public Pagination first() {
            this.currentPage = 0;
            return this;
        }

        public Pagination previous() {
            if (!this.isFirst()) {
                --this.currentPage;
            }

            return this;
        }

        public Pagination next() {
            if (!this.isLast()) {
                ++this.currentPage;
            }

            return this;
        }

        public Pagination last() {
            this.currentPage = this.items.length / this.itemsPerPage;
            return this;
        }

        public Pagination addToIterator(SlotIterator iterator) {
            ClickableItem[] var2 = this.getPageItems();
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                ClickableItem item = var2[var4];
                iterator.next().set(item);
                if (iterator.ended()) {
                    break;
                }
            }

            return this;
        }

        public Pagination setItems(ClickableItem... items) {
            this.items = items;
            return this;
        }

        public Pagination setItemsPerPage(int itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
            return this;
        }
    }
}
