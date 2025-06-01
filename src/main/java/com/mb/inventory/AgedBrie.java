package com.mb.inventory;

import com.mb.Item;

public final class AgedBrie implements InventoryItemType {

    @Override
    public Item update(Item item) {
        item = item.increaseQualityByOneWhenBelowMax();

        item = item.decreaseSellIn();

        if (item.isExpired()) {
            item = item.increaseQualityByOneWhenBelowMax();
        }

        return item;
    }
}
