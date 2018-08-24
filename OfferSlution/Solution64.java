package OfferSlution;

import java.util.ArrayDeque;
import java.util.ArrayList;


/**
 * 测试用例 2,3,4,2,6,2,5,1     3
 * 测试用例 2,3,4,2,6,2,5,1     1
 *
 * 使用 min函数 + 两个栈实现队列
 * 思路：入栈时 判断最大值
 */
public class Solution64 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || size <= 0 || num.length < size) {
            return result;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {

            // 去尾，保证前面没有比【num[i]】小的元素
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.removeLast();
            }
            // index 过期
            while (!deque.isEmpty() && deque.peekFirst() == i - size) {
                deque.removeFirst();
            }
            deque.addLast(i);

            // 是否需要加入result
            if(i >= size -1 ) {
                result.add(num[deque.getFirst()]);
            }
        }
        return result;
    }
}


/*
class Test {

    public static void main(String[] args) {
        ArrayList<Integer> result = new Solution64().maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
        for (int i = 0; i < result.size(); i++) {
            Integer integer =  result.get(i);
            System.out.println(integer);
        }
    }
}*/
