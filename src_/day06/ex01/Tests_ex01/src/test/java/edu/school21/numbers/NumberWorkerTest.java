package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker;

    @BeforeEach
    void numberWorkerInitialization() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1, Integer.MIN_VALUE, -12105, - 1212024})
    void isPrimeIncorrectArgs(int arg) {
        Assertions.assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(arg));
    }

    @ParameterizedTest
    @ValueSource (ints = {2, 3, 5, 7, 11, 23, 31, 43, 101, 499})
    void isPrimeTrue(int arg) {
        Assertions.assertTrue(numberWorker.isPrime(arg));
    }

    @ParameterizedTest
    @ValueSource (ints = {4, 6, 8, 9, 34, 35, 36, 38, 39, 40, 42, 44, 45, 49, 50, 51, 52, 54, 55, 62, 102, 498})
    void isPrimeFalse(int arg) {
        Assertions.assertFalse(numberWorker.isPrime(arg));//Не правильно определено простое число
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/data.csv")
    void digitsSum(int arg, int expected) {
        Assertions.assertEquals(expected, numberWorker.digitsSum(arg));
    }


    @Test
    void toStringException() {
        Assertions.assertSame(new IllegalNumberException().toString(), "[ERROR] wrong argument");//Не правильно выведено сообщение об ошибке
    }
}