package com.gildedrose;

/**
 * Created by arjun on 09/09/2016.
 */

import static org.junit.Assert.*;

import com.gildedrose.Items.Item;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void degradeItemsAtANormalRate() {

        Item[] items = new Item[]{new Item("randomItem", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void degradeItemsPastSellInDate() {

        Item[] items = new Item[]{new Item("randomItem", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void doesAgedBrieIncreaseInQualityAfterSellIn() {

        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void onlyAgedBrieIncreasesInQuality() {

        Item[] items = new Item[]{new Item("Aged Brie", 0, 0), new Item("random Item", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    public void ensureSulfurasDoesNotDegrade() {

        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        Item[] inDateItems = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose inDateApp = new GildedRose(inDateItems);
        inDateApp.updateQuality();
        assertEquals(80, inDateApp.items[0].quality);
        assertEquals(0, inDateApp.items[0].sellIn);
    }

    @Test
    public void agedBrieQualityCannotGoAbove50() {

        Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void qualityCannotDegradeIntoNegative() {

        Item[] items = new Item[]{new Item("Random Item", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesIncreasesInPrice() {

        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 4; i++) {

            app.updateQuality();
        }
        assertEquals(24, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesByTwoWhenTenDaysToSellIn() {

        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesByThreeWhenFiveDaysToSellIn() {

        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    @Test
    public void backStagePassesGetResetToZeroAfterSellInDate() {

        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFastAsARegularItem() {

        Item[] items = new Item[]{new Item("Random Item", 5, 5), new Item("Conjured item", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        assertEquals(3, app.items[1].quality);
    }
}

