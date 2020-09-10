/*


 */

import java.util.HashMap;

public class Test_28_数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else {
                hashMap.put(nums[i],1);
            }
            if (hashMap.get(nums[i]) > (nums.length/2)){
                return nums[i];
            }
        }
        return 0;
    }
}
