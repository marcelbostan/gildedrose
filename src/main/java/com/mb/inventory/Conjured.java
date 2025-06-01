package com.mb.inventory;

import com.mb.Item;

public final class Conjured implements InventoryItemType {
    @Override
    public Item update(Item item) {
        item = item.decreaseSellIn();
        item = item.decreaseQualityByTwo();
        if (item.isExpired()) {
            item = item.decreaseQualityByTwo();
        }
        return item;
    }
}
