package io.kpsoft.test;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("Should not instantiate");
    }

    public static boolean isStringNotEmpty(String inputToCheck) {
        return null != inputToCheck && !inputToCheck.isEmpty();
    }
}
