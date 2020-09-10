package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 组合总数2 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        bakctrack(path,candidates,target,0);
        return res;
    }

    /*
    [10,1,2,7,6,1,5]
            8

    第一次只是用used的情况：[[1,1,6],[1,2,5],[1,5,2],[1,6,1],[1,7],[1,1,6]。。。。
        根据上题的经验：当遍历 1 为初始节点时 ，后面节点均不允许用1
     */
//    public void bakctrack(ArrayList<Integer> path,int[] candidates, int target,boolean[] used){
//
//        if (target == 0){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < candidates.length; i++) {
//            if (!used[i]){
//                path.add(candidates[i]);
//                used[i] = true;
//                bakctrack(path,candidates,target - candidates[i],used);
//                path.remove(path.size() - 1);
//                used[i] = false;
//            }
//        }
//    }


    /*第二次剪枝：[[1,1,6],[1,2,5],[1,5,2],[1,7],[1,2,5],[1,5,2],[1,7],[2,1,5],[2,6],[5,1,2],[6,2],[7,1]]
        还是有重复：原因：原数组有重复，比如：当第一个1使用后，状态里认为第二个1是没有使用的

        public void bakctrack(ArrayList<Integer> path,int[] candidates, int target,boolean[] used,int index){

        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (!used[i]){
                path.add(candidates[i]);
                used[i] = true;
                bakctrack(path,candidates,target - candidates[i],used,index);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
    */

    /*
    第三次剪枝：
        1.先对数组排序
        2.如果某个数字与上个数字相同，剪枝
     */
    public void bakctrack(ArrayList<Integer> path,int[] candidates, int target,int index){

        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (target - candidates[i] < 0){
                break;
            }

            //删除重复的整枝:
            //  由于大部分情况下 i是有begin开始的，只有在 开始新的分支的情况下例外，所以i>index表示开始新的分支，
            //   开始新的分支后：以[1,2,2',5]为例，[1,2,5]已经完成，现在到[1,2']了，即新分支，2'的下标是3，而begin还是2（出栈的原因）
            //   这时候 candidates[i] == candidates[i - 1]比较的就是 2’和2的值是否相同
            if (i > index && candidates[i] == candidates[i - 1] ){
                continue;
            }

            //还存在在一个树下的重复
//            if (i > 0 && candidates[i] == candidates[i - 1])


        path.add(candidates[i]);
        bakctrack(path,candidates,target - candidates[i],i+1);
        path.remove(path.size() - 1);


        }


    }

    public static void main(String[] args) {
        int target = 5;
        int[] candidates = {2,5,2,1,2};
        组合总数2 solution = new 组合总数2();
        System.out.println(solution.combinationSum2(candidates,target));
    }



}