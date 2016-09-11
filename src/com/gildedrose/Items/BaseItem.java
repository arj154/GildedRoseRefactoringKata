package com.gildedrose.Items;

/**
 * Created by arjun on 10/09/2016.
 */
public abstract class BaseItem extends Item {


    public static int BASE_DEGRADE_RATE = -1;
    public static int BASE_INCREASE_RATE = 1;


    public BaseItem(String name, int sellIn, int quality) {

        super(name, sellIn, quality);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public BaseItem(Item item) {

        super(item.name, item.sellIn, item.quality);
        name = item.name;
        sellIn = item.sellIn;
        quality = item.quality;

    }


    @Override
    public String toString() {

        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


    public static boolean equalTo(Item item) {

        return false;
    }

    public abstract void modify();

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getSellIn() {

        return sellIn;
    }

    public void setSellIn(int sellIn) {

        this.sellIn = sellIn;
    }

    public int getQuality() {

        return quality;
    }

    public void setQuality(int quality) {

        if (quality >= 0 && quality <= 50) {

            this.quality = quality;
        } else if (quality > 50) {

            this.quality = 50;
        } else if (quality < 0)
        {
            this.quality = 0;
        }
    }
}
