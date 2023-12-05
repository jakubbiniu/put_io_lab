package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        int x = 1;
        int y = 2;
        int predictedResult = 3;
        int result = calculator.add(x, y);
        assertEquals(predictedResult, result);
    }

    @Test
    void testMultiply() {
        int x = 1;
        int y = 2;
        int predictedResult = 2;
        int result = calculator.multiply(x, y);
        assertEquals(predictedResult, result);
    }

    @Test
    void testAddPositveNumbers() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           calculator.addPositiveNumbers(-2, 1);
        });
        Assertions.assertEquals("The arguments must be positive", thrown.getMessage());
    }


}