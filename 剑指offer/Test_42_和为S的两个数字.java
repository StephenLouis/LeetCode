/*


 */

public class Test_42_和为S的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] > target){
                right --;
            }
            if (nums[left] + nums[right] < target){
                left ++;
            }
            if (nums[left] + nums[right] == target){
                return new int[]{nums[left],nums[right]};
            }
        }
        return  new int[0];

    }
}
