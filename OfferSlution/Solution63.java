package OfferSlution;

import java.util.Comparator;
import java.util.PriorityQueue;
/*class Test{
    public static void main(String[] args) {
        Solution63 temp = new Solution63();
        temp.Insert(1);
        temp.Insert(2);
        temp.Insert(3);
        temp.Insert(4);
        System.out.println(temp.GetMedian());
    }
}*/

public class Solution63 {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int count = 0;
    // 大根堆的数据 要小于 小根堆的数据
    public void Insert(Integer num) {
        if((count & 1) == 0){
            minHeap.offer(num);
            int temp = minHeap.poll();
            // 加入大根堆（左边）
            maxHeap.offer(temp);
        }
        else {
            // 加入小根堆（右边）
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.add(temp);
        }
        count++;

    }

    public Double GetMedian() {
        // 偶数
        if(count == 0)
            throw  new RuntimeException("count == 0");
        double result;
        if ((count & 1) == 0){
            int temp1 = maxHeap.peek();
            int temp2 = minHeap.peek();
            result = (temp1 + temp2) / 2.0;
        }
        else
            result = maxHeap.peek();
        return result;
    }
}
