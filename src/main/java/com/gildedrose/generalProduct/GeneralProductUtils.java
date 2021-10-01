package com.gildedrose.generalProduct;

import com.gildedrose.models.Item;
import com.gildedrose.utils.ProductUtilAbstract;

public class GeneralProductUtils extends ProductUtilAbstract {

    @Override
    public void updateQuality(Item item) {
            decreaseQuality(item);
            updateSellIn(item);
    }

    /*
     * Decreases quality of all general products
     * */
    public void decreaseQuality(Item item){
        if(item.quality>0)
            if(item.sellIn<=0)
                item.quality = Math.max(0, item.quality -2 );
            else
                item.quality--;
    }
}
