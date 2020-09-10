import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明
 *
 * @author lupeng11@meituan.com
 * @date 2020/5/23 23:31
 */
public class demo {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;

    }



}
