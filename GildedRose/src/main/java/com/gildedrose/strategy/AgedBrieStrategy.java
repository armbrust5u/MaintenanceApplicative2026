package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy implements UpdateStrategy {
    public void update(Item item) {
        item.sellIn--;
        int increment = item.sellIn < 0 ? 2 : 1;
        if (item.quality < 50) {
            item.quality = Math.min(item.quality + increment, 50);
        }
    }
}