package OfferSlution;

import java.util.HashMap;

/*class Test{
    public static void main(String[] args) {
        RandomListNode p1 = new RandomListNode(1);
        RandomListNode p2 = new RandomListNode(2);
        RandomListNode p3 = new RandomListNode(3);
        RandomListNode p4 = new RandomListNode(4);
        RandomListNode p5 = new RandomListNode(5);
        p1.next = p2;p2.next = p3;p3.next = p4;p4.next = p5;
        p1.random = p3;p2.random = p5;p4.random = p2;
        RandomListNode pClone = new Solution25().Clone(p1);
        while (pClone != null){
            System.out.println(pClone.label + " random : " + pClone.random.label);
        }
    }
}*/
public class Solution25 {
    /*
    空间换时间的做法
     */
    public RandomListNode Clone_ZoomToTime(RandomListNode pHead) {
        if(pHead == null)
            return null;
        RandomListNode pClonedHead = new RandomListNode(pHead.label);
        RandomListNode pNode = pHead.next;
        RandomListNode pClonedNode = pClonedHead;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        map.put(pHead,pClonedHead);
        while (pNode != null){
            pClonedNode.next = new RandomListNode(pNode.label);
            pClonedNode = pClonedNode.next;
            // 当前值
            map.put(pNode,pClonedNode);
            pNode = pNode.next;
        }
        pNode = pHead;
        pClonedNode = pClonedHead;
        while (pNode != null){
            pClonedNode.random = map.get(pNode.random);
            pNode = pNode.next;
            pClonedNode = pClonedNode.next;
        }
        return pClonedHead;
    }

    // O(N)时间，的算法，复杂问题简单化
    public RandomListNode Clone(RandomListNode pHead) {
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReConnectNodes(pHead);
    }
    public void CloneNodes(RandomListNode pHead){
        if(pHead == null)
            return;
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pClonedNode = new RandomListNode(pNode.label);
            pClonedNode.next = pNode.next;
            pNode.next = pClonedNode;
            pNode = pClonedNode.next;
        }
    }

    public void ConnectRandomNodes(RandomListNode pHead){
        if(pHead == null)
            return;
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pClonedNode = pNode.next;
            if(pNode.random != null){
                pClonedNode.random = pNode.random.next;
            }
            pNode = pClonedNode.next;
        }
    }

    public RandomListNode ReConnectNodes(RandomListNode pHead){
        if(pHead == null)
            return null;
        RandomListNode ClonedHead = pHead.next;
        RandomListNode pNode = pHead;
        RandomListNode pClonedNode = pHead.next;

        pNode.next = pClonedNode.next;
        pNode = pNode.next;
        while (pNode != null){
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return ClonedHead;
    }
}
