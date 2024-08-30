package org.example.gildedrose.strategy;

import org.example.gildedrose.Item;

public abstract class AbstractItemStrategy {
    protected abstract void updateQualityStrategyIfSellInLessThanZero(Item item);

    protected abstract void updateQualityStrategyIfLessThanFifty(Item item);

    protected abstract void updateQualityStrategyIfGreaterThanZero(Item item);

    public void updateStrategyTemplate(Item item) {
        if (item.quality < 50) {
            updateQualityStrategyIfLessThanFifty(item);
        }
        if (item.quality > 0) {
            updateQualityStrategyIfGreaterThanZero(item);
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            updateQualityStrategyIfSellInLessThanZero(item);
        }
    }
}
