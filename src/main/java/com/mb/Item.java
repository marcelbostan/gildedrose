package com.mb;


public record Item(String name, int sellIn, int quality) {
    private static final int MAX_QUALITY = 50;
    public Item increaseQualityByOneWhenBelowMax() {
        if (quality < MAX_QUALITY) {
            return new Item(name, sellIn, quality + 1);
        }
        return this;
    }

    public Item decreaseQualityByOne() {
        if (quality > 0) {
            return new Item(name, sellIn, quality - 1);
        }
        return this;
    }

    public Item decreaseQualityByTwo() {
        if (quality > 1) {
            return new Item(name, sellIn, quality - 2);
        }
        return this;
    }

    public Item decreaseSellIn() {
        return new Item(name, sellIn - 1, quality);
    }

    public Item resetQuality() {
        return new Item(name, sellIn, 0);
    }

    public boolean isExpired() {
        return sellIn < 0;
    }

    public boolean expiresBy(int value) {
        return sellIn < value;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


}