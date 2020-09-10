/*


 */

public class Test_66_机器人的运动范围 {
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0);
    }

    public int dfs(int i, int j){
        if (i >= m || j >= n || k < sum(i)+sum(j) || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1,j) + dfs(i,j+1);
    }

    public static int sum(int num){
        int res = 0;
        while (num != 0){
            res += num % 10;
            num = num / 10;
        }
        return res;
    }

}
