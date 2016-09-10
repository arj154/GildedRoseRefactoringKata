package com.gildedrose.Items;

/**
 * Created by arjun on 10/09/2016.
 */
public class Conjured extends BaseItem {


    private static String CONJURED= "Conjured";

    public Conjured(String name, int sellIn, int quality) {

        super(name, sellIn, quality);
    }

    public Conjured(Item item) {

        super(item);
    }


    public static boolean equalTo(Item item) {

        return item.name.contains(CONJURED);
    }

    @Override
    public void modify() {

        setSellIn(sellIn + BASE_DEGRADE_RATE);
        setQuality(quality + (BASE_DEGRADE_RATE*2));
    }
}
