package com.gildedrose;

import com.gildedrose.models.Item;
import com.gildedrose.models.ItemType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GildedRoseTest {

    @Test
    void testAgeBrie(){
        Item[] items = new Item[] {
            new Item(ItemType.AGED_BRIE.getName(), 1, 0),
            new Item(ItemType.AGED_BRIE.getName(), -1, 0),
            new Item(ItemType.AGED_BRIE.getName(), -1, 49),
            new Item(ItemType.AGED_BRIE.getName(), -1, 50),
        };
        GildedRose app = new GildedRose(items);
        //SIMULATE ONE DAY PASS
        app.updateQuality();

        assertEquals(0,items[0].sellIn);
        assertEquals(1,items[0].quality);

        assertEquals(-2,items[1].sellIn);
        assertEquals(1,items[1].quality);

        assertEquals(-2,items[2].sellIn);
        assertEquals(50,items[2].quality);

        assertEquals(-2,items[3].sellIn);
        assertEquals(50,items[3].quality);

        app.updateQuality();

        assertEquals(-1,items[0].sellIn);
        assertEquals(2,items[0].quality);

        assertEquals(-3,items[1].sellIn);
        assertEquals(2,items[1].quality);

        assertEquals(-3,items[2].sellIn);
        assertEquals(50,items[2].quality);

        assertEquals(-3,items[3].sellIn);
        assertEquals(50,items[3].quality);
    }

    @Test
    void testBackStageTicket(){
        Item[] items = new Item[] {
            new Item(ItemType.BACKSTAGE_PASSES.getName(), 11, 10),
            new Item(ItemType.BACKSTAGE_PASSES.getName(), 10, 10),
            new Item(ItemType.BACKSTAGE_PASSES.getName(), 4, 10),
            new Item(ItemType.BACKSTAGE_PASSES.getName(), -1, 40),
            new Item(ItemType.BACKSTAGE_PASSES.getName(), 4, 48),
        };
        GildedRose app = new GildedRose(items);
        //SIMULATE ONE DAY PASS
        app.updateQuality();

        assertEquals(10,items[0].sellIn);
        assertEquals(11,items[0].quality);

        assertEquals(9,items[1].sellIn);
        assertEquals(12,items[1].quality);

        assertEquals(3,items[2].sellIn);
        assertEquals(13,items[2].quality);

        assertEquals(-2,items[3].sellIn);
        assertEquals(0,items[3].quality);

        assertEquals(3,items[4].sellIn);
        assertEquals(50,items[4].quality);

        //SIMULATE TWO DAY PASS
        app.updateQuality();

        assertEquals(9,items[0].sellIn);
        assertEquals(13,items[0].quality);

        assertEquals(8,items[1].sellIn);
        assertEquals(14,items[1].quality);

        assertEquals(2,items[2].sellIn);
        assertEquals(16,items[2].quality);

        assertEquals(-3,items[3].sellIn);
        assertEquals(0,items[3].quality);

        assertEquals(2,items[4].sellIn);
        assertEquals(50,items[4].quality);
    }

    @Test
    void testSulfuras(){
        Item[] items = new Item[] {
            new Item(ItemType.SULFURAS.getName(), 11, 10),
            new Item(ItemType.SULFURAS.getName(), 0, 80),
            new Item(ItemType.SULFURAS.getName(), 6, 50),
        };
        GildedRose app = new GildedRose(items);
        //SIMULATE ONE DAY PASS
        app.updateQuality();

        assertEquals(10,items[0].sellIn);
        assertEquals(10,items[0].quality);

        assertEquals(-1,items[1].sellIn);
        assertEquals(80,items[1].quality);

        assertEquals(5,items[2].sellIn);
        assertEquals(50,items[2].quality);

    }

    @Test
    void testConjuredItems(){
        Item[] items = new Item[] {
            new Item(ItemType.CONJURED.getName(), 11, 10),
            new Item(ItemType.CONJURED.getName(), 1, 10),
            new Item(ItemType.CONJURED.getName(), 0, 10),
            new Item(ItemType.CONJURED.getName(), 0, 3),
        };
        GildedRose app = new GildedRose(items);
        //SIMULATE ONE DAY PASS
        app.updateQuality();

        assertEquals(10,items[0].sellIn);
        assertEquals(8,items[0].quality);

        assertEquals(0,items[1].sellIn);
        assertEquals(8,items[1].quality);

        assertEquals(-1,items[2].sellIn);
        assertEquals(6,items[2].quality);

        assertEquals(-1,items[3].sellIn);
        assertEquals(0,items[3].quality);

        //SIMULATE TWO DAY PASS
        app.updateQuality();

        assertEquals(9,items[0].sellIn);
        assertEquals(6,items[0].quality);

        assertEquals(-1,items[1].sellIn);
        assertEquals(4,items[1].quality);

        assertEquals(-2,items[2].sellIn);
        assertEquals(2,items[2].quality);

        assertEquals(-2,items[3].sellIn);
        assertEquals(0,items[3].quality);

    }

    @Test
    void testGeneralFoods(){
        Item[] items = new Item[] {
            new Item("milk", 11, 10),
            new Item("patato", 0, 10),
            new Item("eggs", 0, 1),
        };
        GildedRose app = new GildedRose(items);
        //SIMULATE ONE DAY PASS
        app.updateQuality();

        assertEquals(10,items[0].sellIn);
        assertEquals(9,items[0].quality);

        assertEquals(-1,items[1].sellIn);
        assertEquals(8,items[1].quality);

        assertEquals(-1,items[2].sellIn);
        assertEquals(0,items[2].quality);

        //SIMULATE TWO DAY PASS
        app.updateQuality();

        assertEquals(9,items[0].sellIn);
        assertEquals(8,items[0].quality);

        assertEquals(-2,items[1].sellIn);
        assertEquals(6,items[1].quality);

        assertEquals(-2,items[2].sellIn);
        assertEquals(0,items[2].quality);

    }


}
