package Matala3;

import java.util.Scanner;

public class Ex1 {
    public static boolean checkOddOrDouble(int number) {
        Scanner scanner = new Scanner(System.in);
        while (number < 0) {
            System.out.println("Please enter a positive & integer number");
            int newNumber = scanner.nextInt();
            number = newNumber;
        }
        if (number == 0)
            return true;
        if ((number % 10) % 2 == (number / 10 % 10) % 2)
            return false;
        return checkOddOrDouble(number / 10);
    }

    public static int indexSumOfDigitsNumber(int[] arr) {
        int indexOfSumMin = 0;
        int minSum = 0; //no error message now
        int tempMinSum = 999999999;
        int i = 0;
        int noChangeOfArr=noChangeNumber(arr);
        if (noChangeOfArr==-1)
            return -1;
        else
        for ( i = 0; i < arr.length; i++)
            if (checkOddOrDouble(arr[i]) == true) {
                minSum = sumDigits(arr[i]);
                if (minSum < tempMinSum) {
                    tempMinSum = minSum;
                }
            }
            int[] arrCopy = new int[arr.length];
            arrCopy = sumArr(arr);
            indexOfSumMin = indexOfMin(arrCopy, tempMinSum);

        return indexOfSumMin;
    }
    public static int sumDigits(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static int[] sumArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sumDigits(arr[i]);
        }
        return arr;
    }

    public static int indexOfMin(int[] arr, int sum) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == sum) {
                return i;
            }
        }
        return i;
    }
    public static int noChangeNumber(int []arr) {
        int i = 0;
        for (i = 0; i < arr.length; i++)
            while (checkOddOrDouble(arr[i]) == false) {
                return -1;
            }
        return 1;
    }


    public static void main(String[] args) {
        int[] arr3 = new int[3];
        arr3 = new int[]{123, 182, 1234};
        int a = indexSumOfDigitsNumber(arr3);
        int b= noChangeNumber(arr3);
        System.out.println(a);
    }
}


