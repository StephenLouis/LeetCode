package 常见搜索算法;

import java.util.ArrayList;

public class quickSort {
    public void quickSort(){
        int[] list = {1,2,3,4,5,6};

        int low = 0;
        int high = list.length - 1;
        int tmp;

        for (int i = 1; i < list.length; i++) {
            while (low != high){
                if (list[low] < list[i]){
                    tmp = list[i];
                    list[i] = list[low];
                    list[low] = tmp;
                    low++;
                }else {

                }
            }
        }



    }
}
