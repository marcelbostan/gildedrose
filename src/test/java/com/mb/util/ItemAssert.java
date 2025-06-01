package com.mb.util;


import com.mb.Item;
import org.assertj.core.api.AbstractAssert;

public class ItemAssert extends AbstractAssert<ItemAssert, Item> {
    public ItemAssert(Item actual) {
        super(actual, ItemAssert.class);
    }

    public static ItemAssert assertThatItem(Item actual) {
        return new ItemAssert(actual);
    }

    public ItemAssert hasName(String expectedName) {
        isNotNull();
        if (!actual.name().equals(expectedName)) {
            failWithMessage("Expected item name to be <%s> but was <%s>", expectedName, actual.name());
        }
        return this;
    }

    public ItemAssert hasSellIn(int expectedSellIn) {
        isNotNull();
        if (actual.sellIn() != expectedSellIn) {
            failWithMessage("Expected sellIn to be <%s> but was <%s>", expectedSellIn, actual.sellIn());
        }
        return this;
    }

    public ItemAssert hasQuality(int expectedQuality) {
        isNotNull();
        if (actual.quality() != expectedQuality) {
            failWithMessage("Expected quality to be <%s> but was <%s>", expectedQuality, actual.quality());
        }
        return this;
    }

    public ItemAssert hasZeroQuality() {
        return hasQuality(0);
    }

    public ItemAssert hasNegativeSellIn() {
        isNotNull();
        if (actual.sellIn() >= 0) {
            failWithMessage("Expected sellIn to be negative but was <%s>", actual.sellIn());
        }
        return this;
    }
}
