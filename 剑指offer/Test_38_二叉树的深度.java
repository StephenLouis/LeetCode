/*


 */

public class Test_38_二叉树的深度 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return preorder(root);
    }

    public int preorder(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = preorder(root.left) + 1;
        int right = preorder(root.right) + 1;
        return Math.max(left,right);
    }
}
