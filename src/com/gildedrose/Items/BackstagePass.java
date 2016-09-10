package com.gildedrose.Items;

/**
 * Created by arjun on 10/09/2016.
 */
public class BackstagePass extends BaseItem {


    public BackstagePass(String name, int sellIn, int quality) {

        super(name, sellIn, quality);
    }

    public BackstagePass(Item item) {

        super(item);
    }

    public static boolean equalTo(Item item) {

        return item.name.contentEquals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void modify() {

        setSellIn(getSellIn() - 1);

        if (sellIn < 0) {

            setQuality(0);
        } else if (sellIn < 6) {

            setQuality(quality + BASE_INCREASE_RATE * 3);
        } else if (sellIn < 11) {

            setQuality(quality + BASE_INCREASE_RATE * 2);
        } else {

            setQuality(quality + BASE_INCREASE_RATE);
        }

    }
}
