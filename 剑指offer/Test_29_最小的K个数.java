/*


 */

import java.util.Arrays;

public class Test_29_最小的K个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,0,arr.length-1);
        return Arrays.copyOf(arr,k);
    }

    public static void quickSort(int[] arr,int low,int high){
        if (low > high){
            return;
        }
        int i = low,j = high;
        //基准
        int basic = arr[low];

        while (i < j) {
            while (arr[j] >= basic && i < j) {
                j--;
            }
            while (arr[i] <= basic && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        //最后将基准放在中间（low和high相遇的地方）
        arr[low] = arr[i];
        arr[i] = basic;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }

    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
