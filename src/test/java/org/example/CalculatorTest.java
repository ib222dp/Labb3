package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(calculator.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(3, 2), 1);
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(3, 2), 6);
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.divide(3, 3), 1);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Denominator cannot be zero.", exception.getMessage());
    }

    @Test
    public void testSquareRootOf() {
        assertEquals(calculator.squareRootOf(4), 2);
    }

    @Test
    public void testGetArea() {
        assertNotEquals(calculator.getArea(-1), 0);
    }

    @Test
    public void testGetCircumference() {
        assertEquals(calculator.getCircumference(-1), Double.NaN);
    }


}