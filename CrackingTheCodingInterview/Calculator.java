import java.util.*;

public class Calculator {

    public static double calculate(String expression) {
        Deque<Character> signs = new LinkedList<>();
        Deque<Double> results = new LinkedList<>();

        for (int i = 0; i < expression.length(); ++i) {
            if (Character.isDigit(expression.charAt(i))) {
                if (i > 0 && Character.isDigit(expression.charAt(i - 1))) {
                    double digit = Double.valueOf(String.valueOf(expression.charAt(i)));
                    results.addLast(results.removeLast() * 10 + digit);
                } else if (signs.isEmpty() || signs.peekLast() == '+' ||
                    signs.peekLast() == '-') {
                        results.addLast(Double.valueOf(String.valueOf(expression.charAt(i))));
                } else if (signs.peekLast() == '*' || signs.peekLast() == '/') {
                    double a = results.removeLast();
                    double b = Double.valueOf(String.valueOf(expression.charAt(i)));
                    char sign = signs.removeLast();
                    if (sign == '*') {
                        results.addLast(a * b);
                    } else {
                        results.addLast(a / b);
                    }
                }
            } else {
                signs.addLast(expression.charAt(i));
            }

        }

        double result = results.removeLast();
        if (!signs.isEmpty()) {
            while (!signs.isEmpty()) {
                double prev = results.removeLast();
                char sign = signs.removeLast();
                if (sign == '+') {
                    result = prev + result;
                } else {
                    result = prev - result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Calculator.calculate("100*100"));
    }
}