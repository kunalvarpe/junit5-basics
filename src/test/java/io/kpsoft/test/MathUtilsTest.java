package io.kpsoft.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running the MathUtils Test")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This needs to be run before all");
    }

    @AfterAll
    static void afterAllCleanUp(){
        System.out.println("This needs to be run after all");
    }

    @BeforeEach
    void init(TestInfo testInfo,  TestReporter testReporter) {
        mathUtils = new MathUtils();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running [" + testInfo.getDisplayName() + "] with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class AddTest{
        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2,
                    mathUtils.add(1,1),
                    "The addition of two positive integers should be positive");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            assertEquals(-2,
                    mathUtils.add(-1,-1),
                    "The addition of two negative integers should be negative");
        }
    }

    @Nested
    @DisplayName("subtract method")
    @Tag("Math")
    class SubtractTest{
        @Test
        @DisplayName("when subtracting two positive numbers when first number is greater than second")
        void testSubtractPositive_whenFirstNumberIsGreater() {
            assertEquals(1,
                    mathUtils.subtract(5,4),
                    "The addition of two positive integers should be positive");
        }

        @Test
        @DisplayName("when subtracting two positive numbers when first number is smaller than second")
        void testSubtractPositive_whenFirstNumberIsSmall() {
            assertEquals(-1,
                    mathUtils.subtract(4,5),
                    "The addition of two positive integers should be positive");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testSubtractNegative() {
            assertEquals(0,
                    mathUtils.subtract(-1,-1),
                    "The addition of two negative integers should be negative");
        }
    }

    @Test
    @DisplayName("multiply method")
    @Tag("Math")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(2,0)),
                () -> assertEquals(-2, mathUtils.multiply(2,-1))
        );
    }

    @Test
    @DisplayName("divide method")
    @Tag("Math")
    void testDivide() {
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(12,0), "Divide by zero should throw");
    }

    @Test
    @DisplayName("calculate Circle Area")
    @Tag("Circle")
    void testCalculateCircleArea() {
        assertEquals(314.1592653589793,
                mathUtils.calculateCircleArea(10), "Calculate correct circle area");
    }
}