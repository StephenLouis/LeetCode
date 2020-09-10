/*


 */

public class Test_39_RR_平衡二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public boolean isBalanced(TreeNode root) {
        int res = preorder(root);
        return res != -1;
    }

    public int preorder(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = preorder(root.left);
        if (left == -1){
            return -1;
        }
        int right = preorder(root.right);
        if (right == -1){
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;

        Test_39_RR_平衡二叉树 solution = new Test_39_RR_平衡二叉树();
        System.out.println(solution.isBalanced(treeNode1));


    }

}
