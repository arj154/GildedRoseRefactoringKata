package com.gildedrose;

import com.gildedrose.Items.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arjun on 09/09/2016.
 */
class GildedRose {

    List<Item> items;

    public GildedRose(Item[] items) {

         this.items = Arrays.asList(items);
    }

    public void updateQuality() {

        ArrayList modifiedList = new ArrayList();

        for (Item item : items) {

            BaseItem revisedItem = new NormalItem(item);
            if (AgedBrie.equalTo(item)) {

                revisedItem = new AgedBrie(item);
            } else if (BackstagePass.equalTo(item)) {

                revisedItem = new BackstagePass(item);
            } else if (Sulfuras.equalTo(item)) {

                revisedItem = new Sulfuras(item);
            } else if (Conjured.equalTo(item)) {

                revisedItem = new Conjured(item);
            }

            revisedItem.modify();
            modifiedList.add(revisedItem);
        }

        items = modifiedList;
    }
}
