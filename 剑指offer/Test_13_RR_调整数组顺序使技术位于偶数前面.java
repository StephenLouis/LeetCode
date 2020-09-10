/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */

public class Test_13_RR_调整数组顺序使技术位于偶数前面 {
    //使用新数组，空间换时间
    public void reOrderArray(int [] array) {
        int[] list = new int[array.length];
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[0] % 2 != 0){
                number++;
            }
        }

        int odd = number;
        int even = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[0] % 2 != 0){
                list[even] = array[i];
                even++;
            }else {
                list[odd] = array[i];
                odd++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = list[i];

        }
    }

    //不使用新数组，时间换空间:冒泡排序(记住冒泡)
    public void reOrderArray2(int [] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (array[j] % 2 == 0 && array[j+1]%2 != 0){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
