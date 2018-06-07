package BookCase;


import OfferSlution.ListNode;
import Util.ArraryToListNode;

import java.util.List;

class Test{
    public static void main(String[] args) {
        ListNode p = ArraryToListNode.ArrayToListNode(new int[] {1,2,3,4,5,6});
        p = new Case22_centerListNode().getCenterNode(null);
        System.out.println(p.val);
    }
}
public class Case22_centerListNode {
    public ListNode getCenterNode(ListNode head){
        if(head == null)
            return null;
        ListNode pAHead = head;
        ListNode pBehind = head;
        while (pAHead.next != null){
            pBehind = pBehind.next;
            pAHead = pAHead.next;
            if(pAHead.next == null)
                break;
            else
                pAHead = pAHead.next;
        }
        return pBehind;
    }
}
