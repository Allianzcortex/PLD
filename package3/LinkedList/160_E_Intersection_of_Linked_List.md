Guarantee that all two heads run the same distance.

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA,curB=headB;
        // Wrong logoc for from null -> head
        // is one step and if we move to next 
        // there will be two steps overall.
        // while(curA!=curB) {
        //     if(curA==null) {
        //         curA = headB;
        //     }
        //     if(curB==null) {
        //         curB = headA;
        //     }
        //     curA = curA.next;
        //     curB = curB.next;
        // }

        if(curA==null) {
                curA = headB;
            } else
                curA = curA.next;
                
            if(curB==null) {
                curB = headA;
            } else
                curB = curB.next;
        
        return curA;
    }
}

```