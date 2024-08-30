package org.example.gildedrose.strategy;


import org.example.gildedrose.Item;

public class BackstagePasseStrategy extends AbstractItemStrategy {
    private static void updateQualityToZero(Item item) {
        item.quality = 0;
    }

    private static void upgradeQualityIfLessThanFifty(Item item) {
        if (item.quality < 50) {
            AgedBrieItemStrategy.upgradeQualityByOne(item);
        }
    }

    @Override
    protected void updateQualityStrategyIfSellInLessThanZero(Item item) {
        updateQualityToZero(item);
    }

    @Override
    protected void updateQualityStrategyIfLessThanFifty(Item item) {
        AgedBrieItemStrategy.upgradeQualityByOne(item);
        if (item.sellIn < 11) {
            upgradeQualityIfLessThanFifty(item);
        }
        if (item.sellIn < 6) {
            upgradeQualityIfLessThanFifty(item);
        }
    }

    @Override
    protected void updateQualityStrategyIfGreaterThanZero(Item item) {

    }
}
