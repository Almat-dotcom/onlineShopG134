package kz.g134.onlineShop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {
    private CalculatorService calculatorService=new CalculatorService();

    @Test
    void addTest(){
        assertEquals(calculatorService.add(5,3), 8);
    }

    @Test
    void multipleTest(){
        assertEquals(calculatorService.multiple(5,3), 15);
    }

    @Test
    void divideTest(){
        assertEquals(calculatorService.divide(10,2), 5);
        assertThrows(ArithmeticException.class, () -> {calculatorService.divide(10, 0);});
    }
}
