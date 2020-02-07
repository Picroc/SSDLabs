import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    final SimpleCalculator calculator = new SimpleCalculator();

    @org.junit.jupiter.api.Test
    void calculate() {
        assertEquals(4, calculator.calculate(2,2,"+"));
        assertEquals(4, calculator.calculate(2,2,"*"));
        assertEquals(0, calculator.calculate(2,2,"-"));
        assertEquals(1, calculator.calculate(2,2,"/"));

        assertEquals(0, calculator.calculate(2,0,"/"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(8, calculator.add(3, 5));
        assertEquals(4.5, calculator.add(1, 3.5));
        assertEquals(2.45, calculator.add(0.35, 2.1));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        assertEquals(0, calculator.subtract(3, 3));
        assertEquals(-6, calculator.subtract(3, 9));
        assertEquals(0.32, calculator.subtract(1.0, 0.68));
        assertEquals(2.55, calculator.subtract(2.87, 0.32));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        assertEquals(8, calculator.multiply(4, 2));
        assertEquals(0, calculator.multiply(1212121, 0));
        assertEquals(-1, calculator.multiply(0.5, -2));
        assertEquals(0.25, calculator.multiply(0.5, 0.5));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        assertEquals(1, calculator.divide(55, 55));
        assertEquals(11, calculator.divide(44, 4));
        assertEquals(0, calculator.divide(55, 0));
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(0.25, calculator.divide(0.1, 0.4));
    }
}