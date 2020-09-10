/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39

 */

import java.util.ArrayList;

public class Test_07_斐波拉契数列 {
    public int Fibonacci(int n) {
        if (n <= 1){
            return n;
        }else {
            int[] array = {0,1};
            for (int i = 2; i <= n; i++) {
                //这里的奇偶判断可以优化成 array[i%2]
                if (i%2 == 0){
                    array[0] = array[0] + array[1];
                }else {
                    array[1] = array[0] + array[1];
                }
            }

            //这里同理也可以优化
            if (n%2 == 0){
                return array[0];
            }else {
                return array[1];
            }
        }
    }
}
