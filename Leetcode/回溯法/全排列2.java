package 回溯法;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 全排列2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(nums,path,used);
        return res;

    }

    public void backtrack(int[] nums,ArrayList<Integer> path,boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            //剪纸:关键在于 !used[i - 1] ：保证是在重复的还没使用时发生剪纸！！
            if (i > 0  && nums[i] == nums[i-1]&& !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,path,used);
            path.remove(path.size()-1);
            used[i] = false;

        }
    }
}