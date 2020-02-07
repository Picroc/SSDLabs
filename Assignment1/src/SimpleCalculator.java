import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SimpleCalculator implements Calculator {

    @Override
    public double calculate(double a, double b, String operation) {
        switch (operation) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                System.out.println("Method unrecognized");
                return 0;
        }
    }

    @Override
    public double add(double a, double b) {
        return (new BigDecimal(a).add(new BigDecimal(b))).round(new MathContext(5)).doubleValue();
    }

    @Override
    public double subtract(double a, double b) {
        return (new BigDecimal(a).subtract(new BigDecimal(b))).round(new MathContext(5)).doubleValue();
    }

    @Override
    public double multiply(double a, double b) {
        return (new BigDecimal(a).multiply(new BigDecimal(b))).round(new MathContext(5)).doubleValue();
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed");
            return 0;
        }
        return (new BigDecimal(a).divide(new BigDecimal(b), 5, RoundingMode.CEILING)).doubleValue();
    }
}
