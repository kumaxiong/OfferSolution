package Util;

import OfferSlution.ListNode;

public class ArraryToListNode {
    public static ListNode ArrayToListNode(int[] array){
        ListNode result = new ListNode(array[0]);
        ListNode behind = result;
        ListNode ahead = null;
        if(array.length == 1)
            return result;
        for (int i = 1; i < array.length; i++) {
            ahead = new ListNode(array[i]);
            behind.next = ahead;
            behind = ahead;
        }
        ahead.next = null;
        return result;
    }
}
