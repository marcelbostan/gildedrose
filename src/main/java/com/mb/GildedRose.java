package com.mb;

import com.mb.inventory.InventoryItemType;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items = Arrays.stream(items)
                .map(this::updateItem)
                .toArray(Item[]::new);
    }

    private Item updateItem(Item item) {
        var inventoryItemProcessor = InventoryItemType.from(item.name());
        return inventoryItemProcessor.update(item);
    }
}