package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureErrorTest {
    private Calculator calculator;
    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void test1() {
        Assertions.assertEquals(0, 1);
    }

    @Test
    void test2() {
        throw new IllegalArgumentException();
    }

    @Test
    void test3(){
        try {
            Assertions.assertEquals(0, 1);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }






}