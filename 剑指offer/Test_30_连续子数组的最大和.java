/*


 */

public class Test_30_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num:nums){
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
