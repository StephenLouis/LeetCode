/*


 */

public class Test_62_二叉搜索树的第k个结点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k,res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null){
            return;
        }
        inorder(root.right);
        if (--k == 0){
            res = root.val;
        }
        inorder(root.left);
    }
}
