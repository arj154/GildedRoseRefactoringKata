package com.gildedrose;

import com.gildedrose.Items.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arjun on 09/09/2016.
 */
class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {

         this.items = items;
    }

    public void updateQuality() {


        for (int i = 0; i < items.length; i++) {

            BaseItem revisedItem = new NormalItem(items[i]);
            if (AgedBrie.equalTo(items[i])) {

                revisedItem = new AgedBrie(items[i]);
            } else if (BackstagePass.equalTo(items[i])) {

                revisedItem = new BackstagePass(items[i]);
            } else if (Sulfuras.equalTo(items[i])) {

                revisedItem = new Sulfuras(items[i]);
            } else if (Conjured.equalTo(items[i])) {

                revisedItem = new Conjured(items[i]);
            }

            revisedItem.modify();
            items[i] = revisedItem;
        }
    }
}
