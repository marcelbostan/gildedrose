package com.mb.inventory;

import com.mb.Item;

public final class AgedBrie implements InventoryItemType {

    @Override
    public Item update(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        return item;
    }
}
