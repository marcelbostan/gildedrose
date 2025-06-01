package com.mb;

import com.mb.inventory.InventoryItemType;
import lombok.Getter;

@Getter
public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        var inventoryItemProcessor = InventoryItemType.from(item.name);
        inventoryItemProcessor.update(item);
    }
}