package OfferSlution;
import java.util.*;
/**
 * 使用两个栈实现队列操作
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        int peek = 0;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) throw new Exception("queue is empty!");
        else peek = stack2.pop();
        return peek;
    }
}
