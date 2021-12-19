package Matala3;

import java.util.Scanner;

public class Ex8 {
    public static final int ARRAY_SIZE = 500;
    Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

        String[] userStringsArr = userStrings();
        String commonSubString = getMostFrequentString(userStringsArr);
        System.out.println("the most frequent substring is: " + (commonSubString));

    }


    //  get a list of strings
    // return the most frequent substring

    public static String getMostFrequentString(String[] stringArray) {
        String[] all = new String[ARRAY_SIZE];
        int allIndex = 0;
        int[] counter = new int[ARRAY_SIZE];

        for (int i = 0; i < stringArray.length; i++) {
            String[] res = getAllSubStrings(stringArray[i]);
            for (int j = 0; j < res.length; j++) {
                int tempIndex = isInArray(res[j], shortenArray(allIndex, all));
                if (tempIndex < 0) {
                    all[allIndex] = res[j];
                    counter[allIndex] = 1;
                    allIndex++;
                } else {
                    counter[tempIndex]++;
                }
            }
        }
        return all[getMaxSubStringIndex(counter)];
    }


    // return index of string in array if found
    // if no string found in array return -1

    public static int isInArray(String stringToSearch, String[] allStringArr) {
        int index = -1;
        for (int i = 0; i < allStringArr.length; i++) {
            if (areEqual(allStringArr[i], stringToSearch)) {
                index = i;
                break;
            }

        }
        return index;
    }


    //compare two strings and return true if they are equal
    public static boolean areEqual(String firstString, String secondString) {
        boolean result = true;
        if (firstString.length() != secondString.length()) {
            result = false;
        } else {
            for (int i = 0; i < firstString.length(); i++) {
                if (firstString.charAt(i) != secondString.charAt(i)) {
                    result = false;
                    break;
                }
            }

        }
        return result;
    }

    // return index of most frequent substring
    public static int getMaxSubStringIndex(int[] counter) {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > max) {
                max = counter[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // get strings from user
    // stops when string length is less than 4
    public static String[] userStrings() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String[] userStrings = new String[ARRAY_SIZE];
        String userStr;
        while (true) {
            System.out.println("enter a word or sentence, when you want to stop enter a word with less than 4 letters");
            userStr = scanner.nextLine();
            if (userStr.length() > 4) {
                userStrings[i] = userStr;
                i++;
            } else {
                break;
            }
        }
        return shortenArray(i, userStrings);
    }


    //get long array and new size and return a shorter array with the given size
    public static String[] shortenArray(int newSize, String[] oldArr) {
        String[] newArr = new String[newSize];
        for (int i = 0; i < newSize; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }


    // return an array of all substrings of a given string
    public static String[] getAllSubStrings(String stringToSubString) {
        String[] subStringArray = new String[ARRAY_SIZE];
        int count = 0;
        //JAVA hello world this is me i am free
        return subStringArray;
}
}
