/*


 */

import java.util.Stack;

public class Test_26_二叉搜索树与双向链表 {


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

    }

    Node head,pre;
    public Node treeToDoublyList(Node root) {
        //每个的第一步都判断下空吧，不知道啥时候有空的测试用例
        if (root == null) return root;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inorder(Node cur){
        if (cur == null) return;
        //访问左子树
        inorder(cur.left);
        //某些操作
        if (head == null){
            head = cur;
            pre = cur;
        }else {
            cur.left = pre;
            pre.right = cur;
            pre = cur;
        }
        //访问右子树
        inorder(cur.right);

    }



}
