import java.util.Scanner;
import java.util.Stack;

public class task03 {
    private static Stack<Double> operandStack;
    private static Stack<Character> operatorStack;

    public static void main(String[] args) {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите число или операцию (+, -, *, /): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("отмена")) {
                    undoLastOperation();
                    continue;
                }

                if (isOperator(input)) {
                    char operator = input.charAt(0);
                    operatorStack.push(operator);
                } else {
                    try {
                        double operand = Double.parseDouble(input);
                        operandStack.push(operand);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: некорректное число.");
                        undoLastOperation();
                        continue;
                    }
                }

                if (operandStack.size() >= 2 && operatorStack.size() >= 1) {
                    double result = performOperation();
                    System.out.println("Ответ: " + result);
                }
            }
        }
    }

    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    private static double performOperation() {
        double secondOperand = operandStack.pop();
        double firstOperand = operandStack.pop();
        char operator = operatorStack.pop();

        double result = 0.0;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    System.out.println("Ошибка: деление на ноль.");
                    undoLastOperation();
                    return 0.0;
                }
                break;
            default:
                System.out.println("Ошибка: некорректная операция.");
                undoLastOperation();
                return 0.0;
        }

        operandStack.push(result);
        return result;
    }

    private static void undoLastOperation() {
        if (!operandStack.isEmpty()) {
            operandStack.pop();
        }

        if (!operatorStack.isEmpty()) {
            operatorStack.pop();
        }

        System.out.println("Отмена.");
    }
}
