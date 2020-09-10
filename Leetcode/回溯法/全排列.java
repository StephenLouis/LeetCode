package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 全排列{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(path,nums,used);
        return res;
    }

    public void backtrack(ArrayList<Integer> path,int[] nums,boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtrack(path,nums,used);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}