package com.gildedrose;

import com.gildedrose.*;
import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;



class GildedRose {
    private static final Map<String, UpdateStrategy> STRATEGIES;

    static {
        STRATEGIES = new HashMap<>();
        STRATEGIES.put("Aged Brie",                                  new AgedBrieStrategy());
        STRATEGIES.put("Backstage passes to a TAFKAL80ETC concert",  new BackstageStrategy());
        STRATEGIES.put("Sulfuras, Hand of Ragnaros",                 new SulfurasStrategy());
    }

    private static final UpdateStrategy DEFAULT = new DefaultStrategy();

    Item[] items;

    public GildedRose(Item[] items) { this.items = items; }

    public void updateQuality() {
        for (Item item : items) {
            STRATEGIES.getOrDefault(item.name, DEFAULT).update(item);
        }
    }
}