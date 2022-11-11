package io.kpsoft.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ExceptionTest {

    @Test
    void test1() {

        NullPointerException npe = new NullPointerException("Boom!!");
        IllegalArgumentException iae = new IllegalArgumentException(npe);
        Throwable throwable = new Throwable(new IllegalStateException(iae));

        assertThat(throwable).getCause()
                             .hasCause(iae)
                             .isInstanceOf(IllegalStateException.class)
                             .getRootCause()
                             .hasMessage("Boom!!")
                             .isInstanceOf(NullPointerException.class);
    }
}
