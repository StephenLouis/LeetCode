/*


 */

public class Test_61_序列化二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    StringBuilder res = new StringBuilder();
    public String serialize(TreeNode root) {
        preoder(root);
        return res.toString();
    }

    public void preoder(TreeNode node){
        if (node == null){
            res.append("#");
            res.append(",");
            return;
        }else {
            res.append(node.val);
            res.append(",");
        }
        preoder(node.left);
        preoder(node.right);
    }

    // Decodes your encoded data to tree.
    int index = -1;
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        TreeNode resNode = myDeserialize(str);
        return resNode;

    }

    public TreeNode myDeserialize(String[] list){
        index ++;
        if (list[index].equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list[index]));
        node.left = myDeserialize(list);
        node.right = myDeserialize(list);

        return node;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;

        Test_61_序列化二叉树 solution = new Test_61_序列化二叉树();
        String res = solution.serialize(one);
        TreeNode reslut = solution.deserialize(res);
        System.out.println(res);


    }


}
