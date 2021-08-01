
Problem description:

```

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

```

这道题的思路是这样的，假设交点存在：

```
. 
  .  上半段距离为 A
    .  
      . . . . . .     重合部分距离为 C
    . 
.    下半段距离为 B

```

那么基本思路就是：A+C+B = B+C+A

即：第一个指针走完 A+C 以后把下半段的指针赋给它，开始走 B.
    第二个指针走完 B+C 以后把上半段的指针赋给它，开始走 A.

一个需要注意的点是：
是 

```Python
 l1 = headB if l1 is None else l1.next
```

还是

```Java
l1 = headB if l1.next is None else l1.next
```

这两种逻辑在交点一定存在的情况下是成立的，但假如两个链表不相交，比如：

```
[2,6,4]
[1,5]
```

那么第二种情况就会陷入死循环，而第一种情况会在 None is None 的情况下
结束。


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
        
        l1,l2 = headA,headB
        
        while True:
            if l1 is l2:
                return l1
            
            l1 = headB if l1 is None else l1.next
            l2 = headA if l2 is None else l2.next
        
        return None
        

```