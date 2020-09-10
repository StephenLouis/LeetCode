package 回溯法;

import java.util.ArrayList;
        import java.util.List;

class 组合总数 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(candidates,target,path,0);
        return res;
    }

    public void backtrack(int[] candidates,int target,ArrayList<Integer> path,int index){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        /*
        比如：target为7时，会产生 [2,2,3] 和 [3,2,2]这样的重复
        剪枝：当  首个节点为2时，已经遍历完了所以含2的合集
                故当 首个节点为3时，不能再使用 2节点，一旦使用： 节点重复
         */
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0){
                break;
            }


            path.add(candidates[i]);
            backtrack(candidates,target - candidates[i],path,i);
            path.remove(path.size()-1);



        }
    }

    public static void main(String[] args) {
        int target = 8;
        int[] candidates = {1,2,5};
        组合总数 solution = new 组合总数();
        System.out.println(solution.combinationSum(candidates,target));
    }
}