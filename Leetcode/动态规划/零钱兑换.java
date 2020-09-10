package Leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lupeng11@meituan.com
 * @date 2020/8/1 16:13
 */
public class 零钱兑换 {
    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            int subproblem = coinChange(coins, amount - coinValue);
            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        map.put(amount, res);
        return res;
    }
}
