package com.gmail.artovod;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private App calculator = new App();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
        assertEquals(0.0, calculator.add(-2.0, 2.0), 0.001);
        assertEquals(-5.0, calculator.add(-2.0, -3.0), 0.001);
    }

    @Test
    public void testSubtract() {
        assertEquals(-1.0, calculator.subtract(2.0, 3.0), 0.001);
        assertEquals(5.0, calculator.subtract(2.0, -3.0), 0.001);
        assertEquals(0.0, calculator.subtract(2.0, 2.0), 0.001);
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
        assertEquals(-6.0, calculator.multiply(-2.0, 3.0), 0.001);
        assertEquals(6.0, calculator.multiply(-2.0, -3.0), 0.001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
        assertEquals(-2.0, calculator.divide(-6.0, 3.0), 0.001);
        assertEquals(2.0, calculator.divide(-6.0, -3.0), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(6.0, 0.0);
    }
}
