package com.gmail.artovod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import io.qameta.allure.*;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

/**
 * Unit test for simple App.
 */
@Epic("Калькулятор")
@Feature("Арифметические операции")
public class AppTest {
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
        try {
            Thread.sleep(new Random().nextInt(1200));
        } catch (InterruptedException ignored) {
        }
        Assertions.assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
        Assertions.assertEquals(0.0, calculator.add(-2.0, 2.0), 0.001);
        Assertions.assertEquals(-5.0, calculator.add(-2.0, -3.0), 0.001);
    }

    @Test
    @Story("Вычитание")
    @Description("Проверка операции вычитания")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testSubtract() {
        try {
            Thread.sleep(new Random().nextInt(1200));
        } catch (InterruptedException ignored) {
        }
        Assertions.assertEquals(-1.0, calculator.subtract(2.0, 3.0), 0.001);
        Assertions.assertEquals(5.0, calculator.subtract(2.0, -3.0), 0.001);
        Assertions.assertEquals(0.0, calculator.subtract(2.0, 2.0), 0.001);
    }

    @Test
    @Story("Умножение")
    @Description("Проверка операции умножения")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testMultiply() {
        try {
            Thread.sleep(new Random().nextInt(1200));
        } catch (InterruptedException ignored) {
        }
        Assertions.assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
        Assertions.assertEquals(-6.0, calculator.multiply(-2.0, 3.0), 0.001);
        Assertions.assertEquals(6.0, calculator.multiply(-2.0, -3.0), 0.001);
    }

    @Test
    @Story("Деление")
    @Description("Проверка операции деления")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testDivide() {
        try {
            Thread.sleep(new Random().nextInt(1200));
        } catch (InterruptedException ignored) {
        }
        Assertions.assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
        Assertions.assertEquals(-2.0, calculator.divide(-6.0, 3.0), 0.001);
        Assertions.assertEquals(2.0, calculator.divide(-6.0, -3.0), 0.001);
    }

    @Test
    @Story("Деление на ноль")
    @Description("Проверка деления на ноль")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("artemovodov")
    @AllureId("8613")
    public void testDivideByZero() {
        try {
            Thread.sleep(new Random().nextInt(1200));
            throw new RuntimeException("loh");
        } catch (InterruptedException ignored) {
        }
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6.0, 0.0);
        });
    }

    @Test
    @Story("Скриншот")
    @Description("Проверка добавления скриншота")
    @Severity(SeverityLevel.NORMAL)
    @Owner("artemovodov")
    public void testScreenshot() throws Exception {
        Thread.sleep(new Random().nextInt(1200));
        Path pathToScreenshot = Path.of("src/resources/Logo.jpg");
        try (InputStream is = Files.newInputStream(pathToScreenshot)) {
            Allure.addAttachment("Скриншот", "image/jpeg", is, ".jpeg");
        }
    }
}
