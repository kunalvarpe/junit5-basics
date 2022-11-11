package io.kpsoft.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.kpsoft.test.StringUtils.*;
import static org.assertj.core.api.Assertions.*;

class StringUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testStringIsEmpty() {
        assertThat(isStringNotEmpty("asd")).isTrue();
        assertThat(isStringNotEmpty("")).isFalse();
    }
}