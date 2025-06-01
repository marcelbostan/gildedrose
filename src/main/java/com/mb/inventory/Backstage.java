package com.mb.inventory;

import com.mb.Item;

public final class Backstage implements InventoryItemType {

    private static final int SELL_IN_THRESHOLD_PLUS_TWO = 11;
    private static final int SELL_IN_THRESHOLD_PLUS_THREE = 6;

    @Override
    public Item update(Item item) {
        item = item.increaseQualityByOneWhenBelowMax();

        if (item.expiresBy(SELL_IN_THRESHOLD_PLUS_TWO)) {
            item = item.increaseQualityByOneWhenBelowMax();
        }

        if (item.expiresBy(SELL_IN_THRESHOLD_PLUS_THREE)) {
            item = item.increaseQualityByOneWhenBelowMax();
        }

        item = item.decreaseSellIn();

        if (item.isExpired()) {
            item = item.resetQuality();
        }

        return item;
    }
}
