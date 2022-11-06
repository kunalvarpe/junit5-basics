package io.kpsoft.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.kpsoft.test.model.Type.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceServiceTest {
    PriceService priceService;

    @BeforeEach
    void setUp() {
        NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
        when(repo.getFactor()).thenReturn(2d);
        priceService = new PriceService(repo);
    }

    @Test
    void testComputePriceRegularMovie() {
        assertThat(priceService.computePrice(REGULAR, -2)).isZero();
        assertThat(priceService.computePrice(REGULAR, 2)).isEqualTo(3);
        assertThat(priceService.computePrice(REGULAR, 0)).isZero();
    }

    @Test
    void testComputePriceNewReleaseMovie() {
        assertThat(priceService.computePrice(NEW_RELEASE, -2)).isZero();
        assertThat(priceService.computePrice(NEW_RELEASE, 2)).isEqualTo(4);
        assertThat(priceService.computePrice(NEW_RELEASE, 0)).isZero();
    }

    @Test
    void testComputePriceChildrenMovie() {
        assertThat(priceService.computePrice(CHILDREN, -2)).isZero();
        assertThat(priceService.computePrice(CHILDREN, 2)).isEqualTo(7);
        assertThat(priceService.computePrice(CHILDREN, 0)).isZero();
    }
}
