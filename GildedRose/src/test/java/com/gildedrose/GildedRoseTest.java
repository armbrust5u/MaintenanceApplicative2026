package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testAgedBriePetiteQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 60, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality);
    }

    @Test
    void testItemHigh() {
        Item[] items = new Item[] { new Item("item", 60, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(59, app.items[0].quality);
    }

    @Test
    void testBackstagePassMoyenPrix() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testBackstagePassPetitPrix() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testBackstagePass3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testItemGratuitBasseQualite() {
        Item[] items = new Item[] { new Item("item", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void testAgedBrieGratuit() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality);
    }

    @Test
    void testBackStageGratuit() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testSulfurasGratuit() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality);
    }

    @Test
    void testAgedBrieBasseQualiteGratuit() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void testSulfurasLowQualite() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
            assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackStageHighVente() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 50, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
    }

    @Test
    void testBackStageLowPrice() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void testBackStageQualityBorder49() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testSulfurasLowPrice() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(40, app.items[0].quality);
    }

    @Test
    void testItemLowPriceLowQuality() {
        Item[] items = new Item[] { new Item("item", -5, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-5, app.items[0].quality);
    }

    @Test
    void testToString() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 50, 50) };
        String res = items[0].toString();
        assertEquals("Sulfuras, Hand of Ragnaros, 50, 50", res);
    }
}
