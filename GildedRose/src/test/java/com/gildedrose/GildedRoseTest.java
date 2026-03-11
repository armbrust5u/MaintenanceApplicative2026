package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void agedBriePetiteQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 60, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality);
    }

    @Test
    void itemRandom() {
        Item[] items = new Item[] { new Item("item", 60, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(59, app.items[0].quality);
    }

    @Test
    void backstagePassMoyenPrix() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstagePassPetitPrix() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void backstagePass3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void itemGratuitBasseQualite() {
        Item[] items = new Item[] { new Item("item", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void agedBrieGratuit() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality);
    }

    @Test
    void backStageGratuit() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sulfurasGratuit() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(60, app.items[0].quality);
    }

    @Test
    void agedBrieBasseQualiteGratuit() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void sulfurasLowQualite() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
            assertEquals(0, app.items[0].quality);
    }

    @Test
    void backStageHighVente() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 50, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
    }

    @Test
    void backStageHighQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void backStageQualityBorder49() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
}
