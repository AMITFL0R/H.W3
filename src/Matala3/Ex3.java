package Matala3;

public class Ex3 {
    public static void main(String[] args) {
        int[] factors = factorization(857834978);
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] +" "+ "|"+" ");
        }
    }
    public static final int ARRAY_SIZE =30;

    public static int[] factorization(int userNum) {
        int count = 0;
        int index = 0;
        int[] intArr = new int[ARRAY_SIZE];
        if (userNum == 1) {
            return new int[]{userNum};
        }
        for (int i = 2; i <= userNum; ++i) {
            while (userNum % i == 0) {
                count++;
                intArr[index] = i;
                userNum = userNum / i;
                index++;
            }
        }
        return shortenArray(count, intArr);
    }
    public static int[] shortenArray(int newSize, int[] oldArr) {
        int[] newArr = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }
}



