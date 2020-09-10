package Leetcode.动态规划.一维问题;

import java.util.Arrays;

public class 最长上升子序列 {
    /**
     * 想明白状态方程 dp[j] = max(dp[i) + 1；
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 0;

        if (len < 2) {
            return len;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //找到前面子序列的最大长度，并赋值：
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;


    }
}
