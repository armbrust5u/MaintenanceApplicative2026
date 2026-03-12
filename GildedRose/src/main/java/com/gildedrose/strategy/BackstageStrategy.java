package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstageStrategy implements UpdateStrategy {
    public void update(Item item) {
        int increment = item.sellIn < 6 ? 3 : item.sellIn < 11 ? 2 : 1;
        item.quality = Math.min(item.quality + increment, 50);
        item.sellIn--;
        if (item.sellIn < 0) item.quality = 0;
    }
}
