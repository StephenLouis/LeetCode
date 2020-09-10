package Leetcode.动态规划.二维问题;

public class 最小路径和 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 5}, {3, 2, 1}};

        最小路径和 ss = new 最小路径和();
        int res = ss.minPathSum(ints);
        System.out.println(res);
    }

}
