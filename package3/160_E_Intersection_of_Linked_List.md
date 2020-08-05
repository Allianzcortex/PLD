Guarantee that all two heads run the same distance.

One thing we need to notice is that if we change the following logic to 

```Java
 if(curA.next==null) {
                curA = headB;
            } else 
                curA = curA.next;
```

Then our logic will be wrong when there are no intersections between two LinkedLists. like

```
[2,6,4]
[1,5]
```
The code will enter into endless loop.
We need to guarantee that at one time those two nodes will be both null
if there is no intersection.


```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode curA=headA,curB=headB;
        while(curA!=curB) {
            if(curA==null) {
                curA = headB;
            } else 
                curA = curA.next;
            if(curB==null) {
                curB = headA;
            } else
                 curB = curB.next;
        }
        
        return curA;
}

```

---

```Python

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None
        curA,curB = headA,headB
        while(curA is not curB):
            curA = headB if curA is None else curA.next
            curB = headA if curB is None else curB.next
        return curA

```