
```Java

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA,curB=headB;
        while(curA!=curB) {
            if(curA==null){
                curA=headB;
            } else {
                curA = curA.next;
            }

            if(curB==null){
                curB = headA;
            } else {
                curB = curB.next;
            }
        }

        return curA;   
    }
}

```