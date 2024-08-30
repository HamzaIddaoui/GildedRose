package org.example.gildedrose.strategy;


import org.example.gildedrose.Item;

public class DefaultItemStrategy extends AbstractItemStrategy {
    private static void downgradeQualityByOne(Item item) {
        item.quality = item.quality - 1;
    }

    @Override
    protected void updateQualityStrategyIfSellInLessThanZero(Item item) {
        if (item.quality > 0) {
            downgradeQualityByOne(item);
        }
    }

    @Override
    protected void updateQualityStrategyIfLessThanFifty(Item item) {
        // There is no change here for the Default Strategy
    }

    @Override
    protected void updateQualityStrategyIfGreaterThanZero(Item item) {
        downgradeQualityByOne(item);
    }
}
