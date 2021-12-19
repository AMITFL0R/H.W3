package Matala3;

public class Ex4 {
    public static void main(String[] args) {
        int[] arrTest = {1,2,3,5,9,7,4};
        boolean result = fullArr(arrTest);
        System.out.println(result);

    }

    public static boolean fullArr(int[] arr) {
        boolean checkFullArr = false;
        if (arr.length == 1) {
            checkFullArr = true;

        } else {
            sort(arr);
            checkFullArr = sortedArr(arr);
        }
        return checkFullArr;
    }


    public static boolean sortedArr(int[] arr) {
        boolean checkfFull = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] + 1) {
                checkfFull = true;
            } else {
                checkfFull = false;
                break;
            }
        }
        return checkfFull;
    }


    public static void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
