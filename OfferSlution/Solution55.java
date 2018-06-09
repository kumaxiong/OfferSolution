package OfferSlution;

public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetNode = MeetNode(pHead);
        if(meetNode == null)
            return null;
        int loopCount = 1;
        ListNode pNode1 = meetNode;
        while (meetNode != pNode1.next){
            loopCount++;
            pNode1 = pNode1.next;
        }

        pNode1 = pHead;
        for (int i = 0; i < loopCount; i++) {
            pNode1 = pNode1.next;
        }
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    public ListNode MeetNode(ListNode pHead){
        // 判断是否是null ，决定节点是否是空（末尾节点）
        if(pHead == null)
            return null;
        ListNode pSlow = pHead.next;
        if(pSlow == null)
            return null;
        ListNode pFast = pSlow.next;
        while (pSlow != null && pFast != null){
            if(pSlow == pFast)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if(pFast != null)
                pFast = pFast.next;
        }
        return null;
    }
}
