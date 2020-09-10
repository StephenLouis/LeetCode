package 面试中的算法.常见排序算法;

/**
 * @author lupeng11@meituan.com
 * @date 2020/8/11 17:48
 */
public class QuickSort {

  public static int sort(int[] nums, int low, int high) {
    //每次都以最右边的元素作为基准值
    int base = nums[high];
    //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环
    while (low < high && nums[low] <= base) {
      low++;
    }
    // 走到这，说明low当前值比base大，于是交换
    if (low < high) {
      int tmp = nums[low];
      nums[low] = nums[high];
      nums[high] = tmp;
      high--;
    }
    //从右边接着扫描
    while (low < high && nums[low] >= base) {
      high--;
    }

    if (low < high) {
      int tmp = nums[low];
      nums[low] = nums[high];
      nums[high] = tmp;
      low++;
    }
    return low;
  }

  public static void quicksork(int[] a, int low, int high) {
    if (low > high) {
      return;
    } else {
      int index = sort(a, low, high);
      quicksork(a, low, index - 1);
      quicksork(a, index + 1, high);
    }

  }

}
