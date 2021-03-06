/*


 */
import java.util.ArrayList;
public class Test_24_RR_二叉树中和为某一值得路径 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() - 1);
        return listAll;
    }


}
