package com.mb.inventory;

import com.mb.Item;

public final class Normal implements InventoryItemType {

    @Override
    public Item update(Item item) {
        item = item.decreaseQualityByOne();

        item = item.decreaseSellIn();

        if (item.isExpired()) {
            item = item.decreaseQualityByOne();
        }
        return item;
    }
}
