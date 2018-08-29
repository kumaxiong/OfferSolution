package OfferSlution;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution46 {


    public int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < m - 1; i++) {
                queue.add(queue.poll());
            }
            queue.remove();
        }

        return queue.remove();
    }

    public int LastRemaining_Array(int n, int m) {
        if(n == 0 || m == 0) {
            return -1;
        }

        int[] array = new int[n];
        int count = 0;
        int index = 0;
        int step = 0;
        while (true) {
            if(array[index] != -1) {
                step++;
                if(step == m) {
                    array[index] = -1;
                    step = 0;
                    count++;
                    if(count == n) {
                        break;
                    }
                }
            }
            index++;
            if(index == n) index = 0;
        }

        return index;
    }
}
/*

class Test {

    public static void main(String[] args) {
        System.out.println(new Solution46().LastRemaining_Array(5, 2));
    }
}*/
