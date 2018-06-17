package OfferSlution;

import java.util.*;

/*class Test{
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();
        result = new Solution29().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
        for(Integer i:result){
            System.out.println(i);
        }
        Integer b = 2;
    }
}*/
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length == 0|| input == null || k <= 0 || k > input.length)
            return result;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if(maxHeap.size() != k)
                // 加入
                maxHeap.offer(input[i]);
            else if(maxHeap.peek() > input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for(Integer i: maxHeap)
            result.add(i);
        return result;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution_Partition(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || input == null || k <= 0 || k > input.length)
            return result;
        int start = 0;
        int end = input.length - 1;
        int index = Partition(input, start, end);
        while (index != k - 1){
            if(index > k - 1){
                end = index - 1;
                index = Partition(input,start,end);
            }
            else{
                start = index + 1;
                index = Partition(input,start,end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int Partition(int[] nums, int start, int end) {
        int keyIndex = (start + end) >> 1;
        int key = nums[keyIndex];
        swap(nums, keyIndex, end);
        int low = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] <= key) {
                swap(nums, i, low);
                low++;
            }
        }
        --low;
        return low;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
