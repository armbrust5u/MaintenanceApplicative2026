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
            // si l'item n'est pas Aged Brie ni le Backstage passes
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // si la qualité est plus grande que 0
                if (items[i].quality > 0) {
                    // si l'item n'est pas Sulfuras
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // on retire 1 à sa qualité
                        items[i].quality = items[i].quality - 1;
                    }
                }
                // sinon
            } else {
                // si la qualité de l'item est en dessous de 50
                if (items[i].quality < QUALITE_MAX) {
                    // on augmente sa qualité de 1
                    items[i].quality = items[i].quality + 1;

                    // si le nom de l'item est le Backstage passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // si son prix est en dessous de 11
                        if (items[i].sellIn < PRIX_MAX1) {
                            // si sa qualité est en dessous de 50
                            if (items[i].quality < QUALITE_MAX) {
                                // on augmente sa qualité de 1
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        // si son prix est en dessous de 6
                        if (items[i].sellIn < PRIX_MAX2) {
                            // si sa qualité est en dessous de 50
                            if (items[i].quality < QUALITE_MAX) {
                                // on augmente sa qualité de 1
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // si l'item n'est pas sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                // on réduit son prix de 1
                items[i].sellIn = items[i].sellIn - 1;
            }

            // si le prix de l'item est en dessous de 0
            if (items[i].sellIn < 0) {
                // si l'item n'est pas Aged Brie
                if (!items[i].name.equals("Aged Brie")) {
                    // si l'item n'est pas le Backstage passes
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // si l'item à une qualité supérieur à 0
                        if (items[i].quality > 0) {
                            // si l'item n'est pas Sulfuras
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // on réduit sa qualité de 1
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                        // sinon
                    } else {
                        // met la qualité à 0
                        items[i].quality = 0;
                    }
                    // sinon
                } else {
                    // si la qualité est en desous de 50
                    if (items[i].quality < QUALITE_MAX) {
                        // augmenter la qualité de 1
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
