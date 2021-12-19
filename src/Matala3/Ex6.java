package Matala3;

public class Ex6 {
    public static void main(String[] args) {
        String str = new String("4+8");
        System.out.println(str);
        String str2 = new String("*4+8");
        System.out.println(isValidExpression(str2));
        System.out.println(calc("2+3*4"));
    }

    public static boolean isOperator(char c) {
        return (c == 42 || c == 45 || c == 43);
    }

    public static boolean isValidExpression(String expr) {
        if (isOperator(expr.charAt(0)) || isOperator(expr.charAt(expr.length() - 1)))
            return false;

        int parenthesis = 0;

        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == 40) {
                parenthesis++;
                if (i == expr.length() - 1)
                    return false;
            }
            if (expr.charAt(i) == 41) {
                parenthesis--;
                if (i == 0) return false;
            }
            if (isOperator(expr.charAt(i))) {
                if (expr.charAt(i - 1) == 40 || expr.charAt(i + 1) == 41 || isOperator(expr.charAt(i + 1))) {
                    return false;
                }
            }
        }
        return (parenthesis == 0);
    }
//      I tried to build Substraining function but was unable to activate it properly

  /*  public static String mySubString(String str, int start) {
        String newStr = " ";
        for (int i = start; i <str.length(); i++) {
            newStr = newStr + str.charAt(i);
        }
        return newStr;
    }*/

    public static int calc(String str) {
        int result = 0;
        String numbers = "0123456789";
        String operations = "+-*";
        for (int i = 0; i < str.length(); i++) {
            if (numbers.contains(str.charAt(i) + "")) {
                result = result * 10 + (Integer.parseInt(str.charAt(i) + ""));
            } else {
                if (str.charAt(i) == '+') {
                    result += calc(str.substring(i + 1));
                }
                if (str.charAt(i) == '-') {
                    result -= calc(str.substring(i + 1));
                }
                if (str.charAt(i) == '*') {
                    result *= calc(str.substring(i + 1));
                }
                break;
            }
        }
        return result;
    }

  /*  public static char[] chars(String str) {
        char[] disassembledString = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            disassembledString[i] = str.charAt(i);
        }
        return disassembledString;
    }
*/
/*    public static int calculator(String string) {
        char[] clac = chars(string);
        int sum;
        int i = 0;
        for (i = 0; i < clac.length; i++)
            sum = Integer.parseInt(String.valueOf(clac[i]));
        return sum = Integer.parseInt(String.valueOf(clac[i]));
    }*/
}