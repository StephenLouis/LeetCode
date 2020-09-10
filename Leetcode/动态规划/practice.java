package Leetcode.动态规划;

/**
 * @author lupeng11@meituan.com
 * @date 2020/7/31 15:45
 */
public class practice {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        dp[0] = 1;

        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }


}
