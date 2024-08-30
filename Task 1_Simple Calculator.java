import java.util.Scanner;

public class CalculatorCLI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, result = 0;
        char operator;
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Enter first number:");
            num1 = sc.nextDouble();

            System.out.println("Enter an operator (+, -, *, /):");
            operator = sc.next().charAt(0);

            System.out.println("Enter second number:");
            num2 = sc.nextDouble();

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operator! Please use +, -, *, or /.");
            }

            System.out.println("Result: " + result);
            System.out.println("Do you want to continue? (yes/no)");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                keepRunning = false;
            }
        }

        System.out.println("Calculator terminated.");
        sc.close();
    }
}
