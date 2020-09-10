package 面试中的算法;
//给10个数，表示1-10每种牌有几张，问最少要多少次能出完
public class getPoker {

    int min = Integer.MAX_VALUE;
    int[] poker;

    public int getCount(int[] arr) {
        poker = arr;
        backtrace(0, 0);
        return min;
    }

    //n表示 x 这张牌的个数
    public void backtrace(int n, int count) {
        if (n >= 10) {
            min = Math.min(min, count);
            return;
        }
        if (poker[n] == 0) {
            backtrace(n + 1, count);
            return;
        }

        int one = getContinue(n);
        int two = getTwoContinue(n);
        if (one > 0) {     //可以打顺子
            //打顺子，把顺子拍数量减1
            divide(n, 1, 5);
            //dfs 遍历
            backtrace(n, count + 1);
            //回溯
            add(n, 1, 5);
        }
        if (two > 0) {     //可以打连对
            divide(n, 2, 3);
            backtrace(n, count + 1);
            add(n, 2, 3);
        }
        if (poker[n] >= 2) {  //可以打对子
            poker[n] -= 2;
            backtrace(n, count + 1);
            poker[n] += 2;
            return;   //因为能打对子就不会打单张，此时return
        }
        {       //打单张
            poker[n]--;
            backtrace(n, count + 1);
            poker[n]++;
        }
    }

    public int getContinue(int n) {     //判断顺子
        //如果当前牌已经是 5 张，后面不可能有顺子了
        if (n + 1 > 6)
            return 0;
        int min = 5;
        for (int i = n; i < n + 5; i++) {
            min = Math.min(min, poker[i]);
        }
        return min;
    }

    public int getTwoContinue(int n) {   //判断连对

        if (n + 1 > 8)
            return 0;
        int min = 5;
        for (int i = n; i < n + 3; i++) {
            min = Math.min(min, poker[i] / 2);
        }
        return min;

    }

    public void divide(int n, int count, int time) {
        for (int i = n; i < n + time; i++) {
            poker[i] = poker[i] - count;
        }
    }

    public void add(int n, int count, int time) {
        for (int i = n; i < n + time; i++) {
            poker[i] = poker[i] + count;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,4,4,4,4,4,4,4,4,4};
        System.out.println(new getPoker().getCount(arr));
    }

}

