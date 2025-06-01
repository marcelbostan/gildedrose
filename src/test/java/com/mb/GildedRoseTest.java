package com.mb;

import org.junit.jupiter.api.Test;

import static com.mb.util.ItemAssert.assertThatItem;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class GildedRoseTest {

    @Test
    void normalItem_degradesBy1EachDay() {
        Item item = new Item("Normal roses", 66, 9);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Normal roses")
                .hasSellIn(65)
                .hasQuality(8);
    }

    @Test
    void normalItem_qualityDoesNotGoNegative() {
        Item item = new Item("Normal roses", 0, 0);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Normal roses")
                .hasNegativeSellIn()
                .hasZeroQuality();
    }

    @Test
    void agedBrie_increasesInQuality() {
        Item item = new Item("Aged Brie", 44, 4);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Aged Brie")
                .hasSellIn(43)
                .hasQuality(5);
    }

    @Test
    void agedBrie_qualityMaxesAt50() {
        Item item = new Item("Aged Brie", 44, 50);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Aged Brie")
                .hasSellIn(43)
                .hasQuality(50);
    }

    @Test
    void sulfuras_neverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 666, 80);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Sulfuras, Hand of Ragnaros")
                .hasSellIn(666)
                .hasQuality(80);
    }

    @Test
    void backstagePasses_increaseBy1WhenSellInAbove10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Backstage passes to a TAFKAL80ETC concert")
                .hasSellIn(14)
                .hasQuality(21);
    }

    @Test
    void backstagePasses_increaseBy2WhenSellInIs10OrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Backstage passes to a TAFKAL80ETC concert")
                .hasSellIn(9)
                .hasQuality(22);
    }

    @Test
    void backstagePasses_increaseBy3WhenSellInIs5OrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Backstage passes to a TAFKAL80ETC concert")
                .hasSellIn(4)
                .hasQuality(23);
    }

    @Test
    void backstagePasses_dropToZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Backstage passes to a TAFKAL80ETC concert")
                .hasNegativeSellIn()
                .hasZeroQuality();
    }

    @Test
    void conjuredItem_degradesTwiceAsFastAsNormal() {
        Item item = new Item("Conjured", 3, 6);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Conjured")
                .hasSellIn(2)
                .hasQuality(4);
    }

    @Test
    void conjuredItem_degradesBy4AfterExpiration() {
        Item item = new Item("Conjured", 0, 6);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .hasSize(1);

        assertThatItem(result[0])
                .hasName("Conjured")
                .hasNegativeSellIn()
                .hasQuality(2);
    }

    @Test
    void allInOne_updateCorrectly() {
        Item[] items = new Item[] {
                new Item("Normal roses", 66, 9),
                new Item("Normal roses", 0, 0),
                new Item("Aged Brie", 44, 4),
                new Item("Aged Brie", 44, 50),
                new Item("Sulfuras, Hand of Ragnaros", 666, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30),
                new Item("Conjured", 3, 6)

        };

        var gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        var result = gildedRose.getItems();

        assertThat(result)
                .extracting("name", "sellIn", "quality")
                .containsExactly(
                        tuple("Normal roses", 65, 8),
                        tuple("Normal roses", -1, 0),
                        tuple("Aged Brie", 43, 5),
                        tuple("Aged Brie", 43, 50),
                        tuple("Sulfuras, Hand of Ragnaros", 666, 80),
                        tuple("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                        tuple("Backstage passes to a TAFKAL80ETC concert", 9, 22),
                        tuple("Backstage passes to a TAFKAL80ETC concert", 4, 23),
                        tuple("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                        tuple("Conjured", 2, 4)
                );
    }
}