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
        for (int i = 0; i < items.length; i++) {
            items[i] = updateItem(items[i]);
        }
    }

    private Item updateItem(Item item) {
        var inventoryItemProcessor = InventoryItemType.from(item.name());
        return inventoryItemProcessor.update(item);
    }
}