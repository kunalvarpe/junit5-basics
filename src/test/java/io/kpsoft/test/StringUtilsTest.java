package io.kpsoft.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testStringIsEmpty(){
        assertTrue(StringUtils.isStringNotEmpty("asd"));
    }
}