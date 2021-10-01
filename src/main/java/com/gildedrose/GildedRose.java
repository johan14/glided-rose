package com.gildedrose;

import com.gildedrose.generalProduct.GeneralProductUtils;
import com.gildedrose.models.Item;
import com.gildedrose.models.ItemType;
import com.gildedrose.specialProduct.SpecialProductUtils;
import com.gildedrose.utils.ProductUtilAbstract;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    Item[] items;
    private final List<String> specialItemsList;
    ProductUtilAbstract productUtilAbstract;

    //Simulates DI
    ProductUtilAbstract specialProductUtil;
    ProductUtilAbstract generalProductUtil;

    public GildedRose(Item[] items) {
        this.items = items;
        specialItemsList = Arrays.stream(ItemType.values()).map(ItemType::getName).collect(Collectors.toList());
        specialProductUtil = new SpecialProductUtils();
        generalProductUtil = new GeneralProductUtils();
    }

    public void updateQuality() {

        for (Item item : items) {
            if (specialItemsList.contains(item.name)) {
                productUtilAbstract = specialProductUtil;
            } else
                productUtilAbstract = generalProductUtil;

            productUtilAbstract.updateQuality(item);
        }
    }
}
