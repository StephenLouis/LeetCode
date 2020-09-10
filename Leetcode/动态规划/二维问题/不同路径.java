package Leetcode.动态规划.二维问题;

public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 第 1 行（行索引为 0）只能沿着边缘走
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 第 1 列（列索引为 0）只能沿着边缘走
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
