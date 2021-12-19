package Matala3;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or sentence");
        String userNewStr = scanner.nextLine();
        System.out.println(switchChars(userNewStr));
    }

    public static char[] theCommonChars(String str) {
        int arraySize = 2;
        char[] maxAndSecondChar = new char[arraySize];
        int count = 0;
        int MaxAmountOfChars = 0;
        int secondAmountOfLetters = 0;
        char maxChar = ' ';
        char secondMaxChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == x) {
                    count++;
                }
            }
            if (count > MaxAmountOfChars && str.charAt(i) != ' ') {
                secondAmountOfLetters = MaxAmountOfChars;
                MaxAmountOfChars = count;
                maxChar = str.charAt(i);
            } else if (count > secondAmountOfLetters && maxChar != str.charAt(i) && str.charAt(i) != ' ') {
                secondAmountOfLetters = count;
                secondMaxChar = str.charAt(i);
            }
            count = 0;

        }
        maxAndSecondChar[0] = maxChar;
        maxAndSecondChar[1] = secondMaxChar;
        return maxAndSecondChar;
    }

    public static String switchChars(String str) {
        char[] maxAndSecond = theCommonChars(str);
        char maxChar = maxAndSecond[0];
        char secondChar = maxAndSecond[1];
        String newSwitchStr = "";
        for (int k = 0; k < str.length(); k++) {
            if (str.charAt(k) == maxChar) {
                newSwitchStr = newSwitchStr + secondChar;

            } else if (str.charAt(k) == secondChar) {
                newSwitchStr = newSwitchStr + maxChar;

            } else {
                newSwitchStr = newSwitchStr + str.charAt(k);
            }
        }
        return newSwitchStr;
    }
}

