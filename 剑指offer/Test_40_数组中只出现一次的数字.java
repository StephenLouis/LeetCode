/*


 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test_40_数组中只出现一次的数字 {

    public int singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >>> i == 1 ){
                    count ++;
                }
            }
            if (count % 3 != 0){
                res = res | 1 << i;
            }
        }
        return res;
    }

}
