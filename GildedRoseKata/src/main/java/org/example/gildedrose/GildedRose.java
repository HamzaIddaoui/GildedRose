package org.example.gildedrose;

import org.example.gildedrose.strategy.AgedBrieItemStrategy;
import org.example.gildedrose.strategy.BackstagePasseStrategy;
import org.example.gildedrose.strategy.DefaultItemStrategy;

import java.util.Arrays;

public class GildedRose {
    Item[] items;
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(GildedRose::strategyFactoryForItem);
    }

    private static void strategyFactoryForItem(Item item) {
        switch (item.name) {
            case SULFURAS:
                return;
            case AGED:
                new AgedBrieItemStrategy().updateStrategyTemplate(item);
                break;
            case BACKSTAGE:
                new BackstagePasseStrategy().updateStrategyTemplate(item);
                break;
            default:
                new DefaultItemStrategy().updateStrategyTemplate(item);
                break;
        }
    }
}
