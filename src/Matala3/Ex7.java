package Matala3;

import java.util.Scanner;

public class Ex7 {
    Scanner scanner = new Scanner(System.in);

    public static final int COOEFFICIENTS_SIZE = 3;

    public static void main(String[] args) {
        String equation = userInput();
        int index;
        if (equation.length() == 12 || equation.length() == 11) {
            if (equation.charAt(0) == '-' || equation.charAt(0) == '+') {
                index = 1;
            } else {
                index = 0;
            }
            if (validateInput(equation, index)) {
                double[] coefficients = evaluate(equation);
                calculateEquationAndPrint(coefficients[0], coefficients[1], coefficients[2]);
            } else {
                System.out.println("The equation is incorrect ");
            }
        } else {
            System.out.println("The equation is incorrect ");
        }
    }


    public static void calculateEquationAndPrint(double a, double b, double c) {
        double d, x1, x2;

        d = ((b * b) - (4 * a * c));
        if (a != 0 && d >= 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            if (d > 0) {
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println(" two solutions found : " +
                        "x1 = " + x1 + "  x2 = " + x2);
            } else {
                System.out.println("one solution found : " +
                        "x = " + x1);
            }
        } else {
            System.out.println("no solution found");

        }


    }

    public static boolean validateInput(String userStr, int index) {
        boolean result = true;

        if (!isDigit(userStr.charAt(index)) && !isDigit(userStr.charAt(index + 5)) && !isDigit(userStr.charAt(index + 8))) {
            result = false;
        }
        if (!isX(userStr.charAt(index + 1)) && !isX(userStr.charAt(index + 6))) {
            result = false;
        }
        if (userStr.charAt(index + 2) != '^' && userStr.charAt(index + 3) != '2' && userStr.charAt(index + 9) != '=' && userStr.charAt(index + 10) != '0') {
            result = false;
        }

        if (!isValidOperation(userStr.charAt(index + 4)) && !isValidOperation(userStr.charAt(index + 7))) {
            result = false;
        }


        return result;
    }


    public static boolean isX(char charX) {
        return charX == 'x' || charX == 'X';
    }

    public static boolean isValidOperation(char charOperation) {
        return charOperation == '+' || charOperation == '-';
    }

    public static boolean isDigit(char charInt) {
        return charInt >= 48 && charInt <= 57;
    }

    public static double[] evaluate(String equation) {
        int index = 0;
        double[] coefs = new double[COOEFFICIENTS_SIZE];
        String tempCo = "";
        for (int i = 0; i < equation.length(); i++) {
            if (index == 0 || index == 1) {
                if (!isX(equation.charAt(i))) {
                    tempCo += equation.charAt(i);
                } else {
                    if (index == 0) {
                        i += 2;
                    } else {
                        i += 1;
                    }
                    coefs[index] = evalNumber(tempCo);
                    index++;
                    tempCo = "";
                }
            } else {
                if (equation.charAt(i) != '=') {
                    tempCo += equation.charAt(i);
                } else {
                    coefs[index] = evalNumber(tempCo);
                    break;
                }
            }
        }
        return coefs;
    }

    public static double evalNumber(String coefficient) {
        double result = 0;
        boolean negative = false;
        if (coefficient.length() == 0) {
            return 1;
        }
        for (int i = 0; i < coefficient.length(); i++) {
            if (coefficient.charAt(i) == '-') {
                negative = true;
            } else if (coefficient.charAt(i) != '+') {
                result = result * 10 + charToInt(coefficient.charAt((i)));
            }
        }
        if (negative) {
            result = result * (-1);
        }

        return result;

    }

    public static double charToInt(char asChar) {
        return asChar - '0';
    }

    public static String userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your quadratic equation,you must put a number before the 'X'  :");
        String equation = scanner.nextLine();
        return equation;
    }

}