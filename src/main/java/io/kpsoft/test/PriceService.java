package io.kpsoft.test;

import io.kpsoft.test.model.Type;

public class PriceService {

    private final NewReleasePriceRepo repo;

    PriceService(NewReleasePriceRepo repo) {
        this.repo = repo;
    }

    public int computeNewReleasePrice(int days) {
        if (days <= 0) return 0;
        return (int) (days * repo.getFactor());
    }

    public int computeRegularPrice(int days) {
        if (days <= 0) return 0;
        return days + 1;
    }

    public int computeChildrenPrice(int days) {
        if (days <= 0) return 0;
        return days + 5;
    }

    public int computePrice(Type type, int days) {
        switch (type) {
            case REGULAR:
                return computeRegularPrice(days);
            case NEW_RELEASE:
                return computeNewReleasePrice(days);
            case CHILDREN:
                return computeChildrenPrice(days);
            default:
                throw new IllegalArgumentException();
        }
    }

}

