package io.kpsoft.test.model;

import java.util.function.BiFunction;

import io.kpsoft.test.PriceService;

public enum Type {
    REGULAR(PriceService::computeRegularPrice),
    NEW_RELEASE(PriceService::computeNewReleasePrice),
    CHILDREN(PriceService::computeChildrenPrice);

     BiFunction<PriceService, Integer, Integer> priceAlgo;

    Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
        this.priceAlgo = priceAlgo;
    }

    public BiFunction<PriceService, Integer, Integer> getPriceAlgo() {
        return priceAlgo;
    }
}