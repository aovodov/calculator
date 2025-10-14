package com.gmail.artovod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

/**
 * Unit test for simple App.
 */
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
    @Feature("Issues bug")
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
    @Feature("Issues bug")
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
    @Feature("Issues bug")
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
    @Feature("Issues bug")
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
    public void testDivideByZero() {
        try {
            Thread.sleep(new Random().nextInt(1200));
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

    @Test
    @Story("Деление на ноль")
    @Description("Проверка деления на ноль")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("artemovodov")
    @AllureId("8613")
    public void testDivideByZeroNEW() {
        try {
            Thread.sleep(new Random().nextInt(1200));
        } catch (InterruptedException ignored) {
        }
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6.0, 0.0);
        });
    }

    @ParameterizedTest(name = "{displayName} [{argumentsWithNames}]")
    @ValueSource(strings = {"John", "Mike"})
    @DisplayName("allureParameterizedTest displayName")
    @Description("allureParameterizedTest description")
    public void allureParameterizedTest(String name) throws InterruptedException {
        switch (name) {
            case "John":
                Thread.sleep(3000);
                break;
            case "Mike":
                Thread.sleep(2500);
                break;
        }
        parameter("Name", name);
    }

    @Test
    @DisplayName("Bug test")
    @Owner("daniil@qameta.io")
    @Feature("Issues")
    void testFromTestops2() {
        step("step 111");
        step("step 2222");
        step("step 3333", () -> {
            step("sub step");
        });
        step("step sleep 60", () -> {
            Thread.sleep(60000);
            step("sub step");
        });
    }

    @Test
    @DisplayName("Bug test")
    @Owner("daniil@qameta.io")
    @Feature("Issues bugs")
    void testFromTestops3() {
        step("lol");
        step("kek");
        step("4eburek", () -> {
            step("sub step");
        });
        step("step sleep 60", () -> {
            Thread.sleep(60000);
            step("sub step");
        });
    }
}
