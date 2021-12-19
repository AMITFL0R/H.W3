package Matala3;

public class Ex2 {
    public static int indexOfMaxBrothers(int[] arr1, int[] arr2) {
        int j, k, g,i= 0;
        int s=0;
        int l=-1;
        int maxNumber=0;
        int[] copyIndex = new int[arr1.length];
        int[] copySumArr1 = new int[arr1.length+1];
        copySumArr1 = sumArr(arr1);
        int[] copySumArr2 = new int[arr2.length+1];
        copySumArr2 = sumArr(arr2);
        for (k = 0; k < copySumArr1.length+1; k++) {
            if ((i>s)){
                copyIndex[l]=i;
                l++;
                if (l>=copySumArr1.length)
                    break;
                i=0;
            }
            else l++;
            copyIndex[l]=0;
            for (g = 0; g < copySumArr2.length; g++) {
                if (copySumArr1[k] == copySumArr2[g]) {
                    i++;
                } else continue;
            }
        }
       maxNumber=maxOfArr(copyIndex) ;
        return indexOfMaxSum(copyIndex,maxNumber);
    }

    public static int[] sumArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sumDigits(arr[i]);
        }
        return arr;
    }

    public static int sumDigits(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static int maxOfArr(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    public static int indexOfMaxSum(int []arr,int number){
        int counter=0;
        int i=0;
        while (number!=arr[i]){
            counter++;
            i++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[3];
        arr1 = new int[]{18245, 1234, 12734,123};
       int[] arr2 = new int[3];
        arr2 = new int[]{123, 123, 17234,1243};
        System.out.println(indexOfMaxBrothers(arr1,arr2));
    }
}
