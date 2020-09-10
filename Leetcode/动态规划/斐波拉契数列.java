package 动态规划;

public class 斐波拉契数列 {
    //自底像上
    public int fib(int N) {
        if (N < 2) return N;
        int[] res = {0,1};
        for (int i = 2; i < N; i++) {
            res[i%2] = res[0] + res[1];
        }
        return res[N%2];
    }

    //备忘录法
    public int fib2(int N){
        if (N < 2) return N;
        int[] memo = new int[N + 1];
        return helper(memo,N);
    }

    public int helper(int[] memo,int n){
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];

    }
}
