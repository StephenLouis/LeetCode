/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

 */

public class Test_08_跳台阶 {
    public int JumpFloor(int target) {
        if (target <= 3) {
            return target;
        } else {
            int[] array = {1, 2};
            for (int i = 3; i <= target; i++) {
                //这里的奇偶判断可以优化成 array[i%2]
                if (i % 2 != 0) {
                    array[0] = array[0] + array[1];
                } else {
                    array[1] = array[0] + array[1];
                }
            }


            //这里同理也可以优化
            if (target % 2 != 0) {
                return array[0];
            } else {
                return array[1];
            }
        }
    }
}
