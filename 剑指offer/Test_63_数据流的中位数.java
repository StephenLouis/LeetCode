/*


 */

import java.util.PriorityQueue;

public class Test_63_数据流的中位数 {
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;
    /** initialize your data structure here. */
    public void MedianFinder() {
        maxheap = new PriorityQueue<>((x,y)->y-x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //这里用offer，防止空指针异常
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if (minheap.size() > maxheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()){
            return ((maxheap.peek()+minheap.peek())*0.5);
        }
        return maxheap.peek();
    }
    
}
