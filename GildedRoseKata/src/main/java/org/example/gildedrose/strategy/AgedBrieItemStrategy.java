package org.example.gildedrose.strategy;


import org.example.gildedrose.Item;

public class AgedBrieItemStrategy extends AbstractItemStrategy {
    public static void upgradeQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }

    @Override
    protected void updateQualityStrategyIfSellInLessThanZero(Item item) {
        if (item.quality < 50) {
           upgradeQualityByOne(item);
        }
    }

    @Override
    protected void updateQualityStrategyIfLessThanFifty(Item item) {
        upgradeQualityByOne(item);
    }

    @Override
    protected void updateQualityStrategyIfGreaterThanZero(Item item) {
        // There is no change here for the Aged Brie Strategy
    }

}
