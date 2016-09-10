package com.gildedrose.Items;

/**
 * Created by arjun on 10/09/2016.
 */
public class Sulfuras extends BaseItem {

    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(String name, int sellIn, int quality) {

        super(name, sellIn, quality);
    }

    public Sulfuras(Item item) {

        super(item);
    }

    public static boolean equalTo(Item item) {

        return item.name.contentEquals(SULFURAS_HAND_OF_RAGNAROS);
    }

    @Override
    public void modify() {

        setSellIn(sellIn + BASE_DEGRADE_RATE);
    }
}
