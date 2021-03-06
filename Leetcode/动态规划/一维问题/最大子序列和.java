package Leetcode.动态规划.一维问题;

public class 最大子序列和 {
    /*
    其实就算是动态规划，也是穷举所有可能性！！
        只不过他在穷举的时候，通过 自底向上 或者 备忘录 法删除了大量重复计算


     */

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 0; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }


        // 最后不要忘记全部看一遍求最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
