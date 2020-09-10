/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

 */

public class Test_10_矩形覆盖 {
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }else {
            int[] array = {1,2};
            for (int i = 3; i <= target; i++) {
                //这里的奇偶判断可以优化成 array[i%2]
                if (i%2 != 0){
                    array[0] = array[0] + array[1];
                }else {
                    array[1] = array[0] + array[1];
                }
            }

            //这里同理也可以优化
            if (target%2 != 0){
                return array[0];
            }else {
                return array[1];
            }
        }

    }
}
