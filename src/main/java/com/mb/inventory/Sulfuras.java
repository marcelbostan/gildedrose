package com.mb.inventory;

import com.mb.Item;

public final class Sulfuras implements InventoryItemType {

    @Override
    public Item update(Item item) {
        //Do nothing
        return item;
    }
}
