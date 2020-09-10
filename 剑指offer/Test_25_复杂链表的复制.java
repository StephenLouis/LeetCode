
public class Test_25_复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node currentNode = head;
        while (currentNode != null){
            //这里必须使用new ，保证每次都会创建新的节点
            Node newNode = new Node(currentNode.val);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            //这里可能有空指针异常
            currentNode = currentNode.next.next;
        }

        currentNode = head;
        while (currentNode != null){
            if (currentNode.random != null){
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }

        currentNode = head;
        Node resNode = currentNode.next;
        while (currentNode != null){
            Node cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            if (cloneNode.next != null){
                cloneNode.next = cloneNode.next.next;
            }
            currentNode = currentNode.next;
        }

        return resNode;
    }

}
