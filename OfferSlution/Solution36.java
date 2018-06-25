package OfferSlution;

import java.util.Stack;

public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        int diff = len1 - len2;
        ListNode pHeadLong = pHead1;
        ListNode pHeadShort = pHead2;
        if (len1 < len2) {
            pHeadLong = pHead2;
            pHeadShort = pHead1;
            diff = len2 - len1;
        }

        for (int i = 0; i < diff; i++) {
            pHeadLong = pHeadLong.next;
        }

        while (pHeadLong != null && pHeadShort != null && pHeadLong != pHeadShort) {
            pHeadLong = pHeadLong.next;
            pHeadShort = pHeadShort.next;
        }

        ListNode pFirstCommenNode = pHeadLong;
        // 如果为空，返回空
        return pFirstCommenNode;
    }

    private int getLength(ListNode p) {
        int count = 0;
        ListNode pNode = p;
        while (pNode != null) {
            pNode = pNode.next;
            count++;
        }
        return count;
    }


    /*
        解法2：使用栈的形式调用
     */
    public ListNode FindFirstCommonNode_stack(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode pNode = pHead1;
        while (pNode != null){
            stack1.push(pNode);
            pNode = pNode.next;
        }
        pNode = pHead2;
        while (pNode != null){
            stack2.push(pNode);
            pNode = pNode.next;
        }

        ListNode pFirstCommonNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek() == stack2.peek()){
                pFirstCommonNode = stack1.peek();
            }
            stack1.pop();
            stack2.pop();
        }
        return pFirstCommonNode;
    }
}
