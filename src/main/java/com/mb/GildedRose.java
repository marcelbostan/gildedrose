package com.mb;

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
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isBackstagePasse = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

        if (isAgedBrie) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        } else if (isBackstagePasse) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        } else if (isSulfuras) {

        } else {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }

}