/**
 * 功能说明
 *
 * @author lupeng11@meituan.com
 * @date 2020/5/23 23:31
 */
public class demo {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;

        return root;

    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode6.left = treeNode2;
        treeNode6.right = treeNode8;
        treeNode2.left = treeNode0;
        treeNode2.right = treeNode4;
        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;

        demo demo = new demo();
        demo.lowestCommonAncestor(treeNode6, treeNode2, treeNode4);
    }
}
