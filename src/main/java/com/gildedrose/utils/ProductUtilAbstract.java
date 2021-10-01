package com.gildedrose.utils;

import com.gildedrose.models.Item;

public abstract class ProductUtilAbstract {

    /*
    * Updates sell in for all kind of products
    * */
    public void updateSellIn(Item item){
        item.sellIn--;
    }

    public abstract void updateQuality(Item item);
}
