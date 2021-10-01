package com.gildedrose.specialProduct;

import com.gildedrose.models.Item;
import com.gildedrose.models.ItemType;
import com.gildedrose.utils.ProductUtilAbstract;

import java.util.Arrays;

public class SpecialProductUtils extends ProductUtilAbstract {

    @Override
    public void updateQuality(Item item) {
            updateQuality(getQualityConsumer(item), item);
    }


    /*
     * Updates quality of special types of items
     * */
    private void updateQuality(SpecialProductConsumer updateQualityConsumer, Item item){
        updateQualityConsumer.accept(item);
        updateSellIn(item);
    }

    /*
    * Returns specific consumer based on item name
    * */
    private SpecialProductConsumer getQualityConsumer(Item item){
        ItemType itemType = Arrays.stream(ItemType.values()).filter(itemType1 -> itemType1.getName().equals(item.name)).findFirst().get();
        SpecialProductConsumer consumer;
        switch (itemType) {
            case AGED_BRIE:
                consumer = agedBrie -> agedBrie.quality = Math.min(++agedBrie.quality, 50);
                break;
            case BACKSTAGE_PASSES:
                consumer = backStagePass -> {
                    if(backStagePass.sellIn>=0){
                        if (backStagePass.sellIn >= 11)
                            backStagePass.quality++;
                        if (backStagePass.sellIn < 11 && backStagePass.sellIn > 5) {
                            backStagePass.quality = Math.min(backStagePass.quality + 2, 50);
                        }
                        if (backStagePass.sellIn <= 5) {
                            backStagePass.quality = Math.min(backStagePass.quality + 3, 50);
                        }
                    }else
                        backStagePass.quality = 0;
                };
                break;
            case SULFURAS:
                consumer = sulfuras -> {

                };
                break;
            case CONJURED:
                consumer = conjured -> {
                    if(conjured.sellIn>0)
                        conjured.quality = Math.max(0, conjured.quality - 2);
                    else
                        conjured.quality = Math.max(0, conjured.quality - 4);
                };
                break;
            default:
                consumer = otherItem -> {
                    System.out.println("Item not found");
                };
                break;
        }
        return consumer;
    }
}
