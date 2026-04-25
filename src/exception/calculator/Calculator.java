package exception.calculator;

public class Calculator {
private static final String PLUS = "+";
private static final String MINUS = "-";
private static final String MULTIPLY = "*";
private static final String DIVIDE = "/";

static double calculate ( double a, double b, String operator) {
    double result = 0;
    switch (operator) {
        case PLUS -> result = a + b;
        case MINUS -> result = a - b;
        case MULTIPLY -> result = a * b;
        case DIVIDE -> {
            if ( b == 0 ) {
                throw new ArithmeticException("Nie można dzilić przez 0");
            } else {
                result = a / b;
            }
        }
        default -> throw new UnknownOperatorException("Niezidentyfikowany operator");
    }
    return result;
}
}
