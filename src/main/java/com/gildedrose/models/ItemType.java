package com.gildedrose.models;

public enum ItemType {

    AGED_BRIE("Aged Brie"), SULFURAS("Sulfuras"), BACKSTAGE_PASSES("Backstage passes"), CONJURED("Conjured");
    private final String name;

    ItemType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
