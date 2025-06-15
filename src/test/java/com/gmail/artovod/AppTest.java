package com.gmail.artovod;

import org.junit.Test;
import static org.junit.Assert.*;
import io.qameta.allure.*;

/**
 * Unit test for simple App.
 */
@Epic("Калькулятор")
@Feature("Арифметические операции")
public class AppTest 
{
    private App calculator = new App();

    /**
     * Rigorous Test :-)
     */
    @Test
    @Story("Сложение")
    @Description("Проверка операции сложения")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("artemovodov")
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
        assertEquals(0.0, calculator.add(-2.0, 2.0), 0.001);
        assertEquals(-5.0, calculator.add(-2.0, -3.0), 0.001);
    }

    @Test
    @Story("Вычитание")
    @Description("Проверка операции вычитания")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testSubtract() {
        assertEquals(-1.0, calculator.subtract(2.0, 3.0), 0.001);
        assertEquals(5.0, calculator.subtract(2.0, -3.0), 0.001);
        assertEquals(0.0, calculator.subtract(2.0, 2.0), 0.001);
    }

    @Test
    @Story("Умножение")
    @Description("Проверка операции умножения")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
        assertEquals(-6.0, calculator.multiply(-2.0, 3.0), 0.001);
        assertEquals(6.0, calculator.multiply(-2.0, -3.0), 0.001);
    }

    @Test
    @Story("Деление")
    @Description("Проверка операции деления")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
        assertEquals(-2.0, calculator.divide(-6.0, 3.0), 0.001);
        assertEquals(2.0, calculator.divide(-6.0, -3.0), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    @Story("Деление на ноль")
    @Description("Проверка деления на ноль")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("artemovodov")
    public void testDivideByZero() {
        calculator.divide(6.0, 0.0);
    }
}
