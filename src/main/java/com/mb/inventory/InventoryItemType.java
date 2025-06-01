package com.mb.inventory;

import com.mb.Item;

public sealed interface InventoryItemType permits AgedBrie, Backstage, Sulfuras, Normal {

    Item update(Item item);

    static InventoryItemType from(String name) {

        return switch (name) {
            case String s when s.contains("Aged Brie") -> new AgedBrie();
            case String s when s.contains("Backstage passes") -> new Backstage();
            case String s when s.contains("Sulfuras") -> new Sulfuras();
            default -> new Normal();
        };
    }
}
