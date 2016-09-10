package com.gildedrose.Items;

/**
 * Created by arjun on 10/09/2016.
 */
public class NormalItem extends BaseItem {

    public NormalItem(String name, int sellIn, int quality) {

        super(name, sellIn, quality);
    }

    public NormalItem(Item item) {

        super(item);
    }

    public static boolean equalTo(Item item) {

        return true;
    }

    @Override
    public void modify() {

        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0) {

            setQuality(getQuality() + (BASE_DEGRADE_RATE * 2));
        } else {

            setQuality(getQuality() + BASE_DEGRADE_RATE);
        }
    }
}
