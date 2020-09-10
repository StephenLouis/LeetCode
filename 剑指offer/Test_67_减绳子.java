/*


 */

import java.util.HashMap;

public class Test_67_减绳子 {
    int[] dic;
    public int cuttingRope(int n) {
        dic = new int[n+1];
        return help(n);

    }

    public int help(int n){
        if (n == 2){
            return 1;
        }
        if (dic[n] != 0){
            return dic[n];
        }
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res,Math.max(i*help(n-i),i*(n-i)));
        }
        dic[n] = res;
        return res;
    }

}
