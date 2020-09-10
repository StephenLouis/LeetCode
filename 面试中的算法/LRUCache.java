package 面试中的算法;


import java.util.HashMap;

public class LRUCache{

    //=======================  双向链表节点定义  =================================================
    class LRUNode{
        int key;
        Object value;
        LRUNode next;
        LRUNode pre;

        public LRUNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }




    //结构提前声明，这是类的属性
    HashMap<Integer, LRUNode> map = new HashMap<>();
    LRUNode head;
    LRUNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Object get(int key) {
        LRUNode node = map.get(key);
        if (node != null) {
            // 把这个节点删除并插入到头结点
            removeAndInsert(node);
            return node.value;
        }
        return null;
    }

    public void put(int key,Object value){
        //首先判断头结点是否是空
        if (head == null) {
            head = new LRUNode(key, value);
            tail = head;
            map.put(key, head);
        }
        //判断key是否已经存在，存在则更新value
        LRUNode node = map.get(key);
        if (node != null) {
            // 更新值
            node.value = value;
            // 把他从链表删除并且插入到头结点
            removeAndInsert(node);
        } else {
            //key不存在，准备插入到最前面。但是插入之前先查看是否缓存满了
            LRUNode tmp = new LRUNode(key, value);
            // 如果会溢出
            if (map.size() >= capacity) {
                // 先把它从哈希表中删除
                map.remove(tail);
                // 删除尾部节点
                tail = tail.pre;
                tail.next = null;
            }
            map.put(key, tmp);
            // 插入到最前面
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
        }



        //其次插入节点，插入之前判断是否满
    }

    private void removeAndInsert(LRUNode node){
        //无论是get方法还是put方法，都需要删除最后一个节点。

        //1.已经是头结点了，那什么都不做
        if (node == head) return;
        //如果是尾节点，则删除
        else if (node == tail) {
            tail = node.pre;
            tail.next = null;
        }
        //如果是其他中间的节点，则删除
        else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 插入到头结点
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;

    }

}
