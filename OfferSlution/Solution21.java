package OfferSlution;

import java.util.Stack;
/*class Test{
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{4,3,5,1,2};
        System.out.println(new Solution21().IsPopOrder(nums1,nums2));
    }
}*/
public class Solution21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length <= 0 || popA.length <= 0 || pushA.length != popA.length)
            return false;
        boolean isPopOrder = false;
        int nextPush = 0;
        int nextPop = 0;
        Stack<Integer> stack = new Stack<>();
        while (nextPop < popA.length) {
            while ( stack.isEmpty()||stack.peek() != popA[nextPop]) {
                if (nextPush == pushA.length)
                    break;
                stack.push(pushA[nextPush]);
                nextPush++;
            }
            if (stack.peek() != popA[nextPop])
                break;
            stack.pop();
            nextPop++;
        }
        if (nextPop == popA.length && stack.isEmpty())
            isPopOrder = true;
        return isPopOrder;
    }
}
