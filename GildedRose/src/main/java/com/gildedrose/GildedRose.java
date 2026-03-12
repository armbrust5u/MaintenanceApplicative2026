package com.gildedrose;

class GildedRose {
    Item[] items;

    final int QUALITE_MAX = 50;
    final int PRIX_MAX1 = 11;
    final int PRIX_MAX2 = 6;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (this.items[i].name) {
                case "Aged Brie":
                    updateAgedBrie(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstage(items[i]);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    updateQualityDefault(items[i]);
                    break;
            }
        }
    }

    private void updateAgedBrie(Item item) {
        // si la qualité de l'item est en dessous de 50
        if (item.quality < QUALITE_MAX) {
            // on augmente sa qualité de 1
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        // si le prix de l'item est en dessous de 0
        if (item.sellIn < 0) {
            // si la qualité est en desous de 50
            if (item.quality < QUALITE_MAX) {
                // augmenter la qualité de 1
                item.quality = item.quality + 1;
            }
        }
    }


    private void updateBackstage(Item item) {
        // si la qualité de l'item est en dessous de 50
        if (item.quality < QUALITE_MAX) {
            // on augmente sa qualité de 1
            item.quality = item.quality + 1;
        }

        if (item.sellIn < PRIX_MAX1) {
            if (item.quality < QUALITE_MAX) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < PRIX_MAX2) {
            if (item.quality < QUALITE_MAX) {
                item.quality = item.quality + 1;
            }
        }

        item.sellIn = item.sellIn - 1;

        // si le prix de l'item est en dessous de 0
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateQualityDefault(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        // si le prix de l'item est en dessous de 0
        if (item.sellIn < 0) {
            // si l'item à une qualité supérieur à 0
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
