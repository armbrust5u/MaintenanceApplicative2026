package com.gildedrose.strategy;

import com.gildedrose.Item;

public class DefaultStrategy implements UpdateStrategy {
    public void update(Item item) {
        item.sellIn--;
        int decrement = item.sellIn < 0 ? 2 : 1;
        // On ne touche pas une quality déjà à 0 ou négative
        if (item.quality > 0) {
            item.quality = Math.max(item.quality - decrement, 0);
        }
    }
}
