/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 */
import java.util.ArrayList;
public class Test_22_R_从上往下打印二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        queue.add(root);
        while (queue.size() != 0){
            TreeNode temp = queue.remove(0);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }
}
