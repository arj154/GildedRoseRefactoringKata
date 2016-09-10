package com.gildedrose.Items;

/**
 * Created by arjun on 10/09/2016.
 */
public class AgedBrie extends BaseItem {

    private static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(String name, int sellIn, int quality) {

        super(name, sellIn, quality);
    }

    public AgedBrie(Item item) {

        super(item);
    }

    public static boolean equalTo(Item item) {

        return item.name.contentEquals(AGED_BRIE);
    }

    @Override
    public void modify() {

        setQuality(quality + BASE_INCREASE_RATE);
        setSellIn(sellIn + BASE_DEGRADE_RATE);
    }
}
