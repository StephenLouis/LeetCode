/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

 */

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class Test_04_R_重建二叉树 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //hashmap用来帮助找index
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] clone;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        clone = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return rebuild(0, 0, inorder.length - 1);
    }

    public TreeNode rebuild(Integer pre_index, int inorder_left, int inorder_right) {
        if (inorder_left == inorder_right) return null;
        int index = dic.get(clone[pre_index]);
        TreeNode root_Node = new TreeNode(clone[pre_index]);
        root_Node.left = rebuild(pre_index + 1, inorder_left, index - 1);
        root_Node.right = rebuild(pre_index + index - inorder_left + 1, index + 1, inorder_right);
        return root_Node;
    }

}
