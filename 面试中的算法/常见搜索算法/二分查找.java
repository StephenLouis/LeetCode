package 面试中的算法.常见搜索算法;

public class 二分查找 {
    public static boolean binarySearch(int[] list,int key){
        int low = 1;
        int high = list.length - 1;
        int mid;

        while (low != high - 1){
            mid = (low + high) / 2;
            if (mid == key){
                return true;
            }else if (mid > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
