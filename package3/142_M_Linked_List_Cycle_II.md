
Problem description :

```

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

```

idea :

如果我们用一个 slow 和一个 fast 指针来遍历整个循环的话，那么：

1. slow 和 fast 一定可以相遇在某一点，这个点不一定是 circle 开始的点
2. fast 所走的距离一定是 slow 的 2 倍

那么就可以来确定关系：

设开始到 circle 循环开始的点距离为 l1，circle 循环点到相遇点距离为 l2，相遇点到 circle 循环点
相遇距离为 l3

那么：

设 slow 指针走了 n 圈，fast 指针走了 m 圈

slow 指针走的距离为： x1 + x2 + n*(x3+x2)
fast 指针走的距离为： x1 + x2 + m*(x3+x2)

它们满足如下的关系：

2*(x1 + x2 + n*(x3+x2)) = x1 + x2 + m*(x3+x2)

合并同类项，两边都除掉一个 x1 和 x2

x1+x2+2n*(x2+x3) = m*(x2+x3)

再把 (x2+x3) 合并

(2n-m)(x2+x3)+x1+x2=0

再进一步我们想消除掉 x2

(2n-m+1)(x2+x3) + (-1)*(x2+x3)+x1+x2 = 0

(2n-m+1)(x2+x3) + (x1-x3) = 0 

则 2n-m+1 一定是常量，x2+x3 是整个 circle 的距离

所以

k*(length of circle) = x3-x1

x1 = x3 - k*(length of circle)

所以如果让两个指针同时从开始点和相遇点出发，相遇点会在跑 k 个 circle 后与另一个点
在循环点相遇

步骤可以分为：

1. 让 slow 和 fast 两个指针相遇在 middle 点
2. 然后让另一个点从 head 与 fast 同时开始走，直到与 fast 再相遇

Python 解法如下：

```Python

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        
        """
         x1        x2
        3 -> 2 -> 0 -> 4 -
             |          |
             -------------- 
             x3
            
    
        assume slow : n circles , fast : m circles
        
        distance of slow : x1 + x2 + n*(x3+x2)
        
        disatance of fast: x1 + x2 + m*(x3+x2)
        
        2*(x1 + x2 + n*(x3+x2)) = x1 + x2 + m*(x3+x2)
        
        x1+x2+2n*(x2+x3) = m*(x2+x3)
        
        (2n-m)(x2+x3)+x1+x2=0
        
        (2n-m+1)(x2+x3) + (-1)*(x2+x3)+x1+x2 = 0
        
        (2n-m+1)(x2+x3) + (x1-x3) = 0  # 2n-m+1 will be a K
        
        k*(length of circle) = x3-x1
        
        """
        
        if head is None or head.next is None:
            return None
        
        slow,fast = head.next,head.next.next
        
        while slow is not fast:
            if fast is None or fast.next is None:
                return None
            
            slow = slow.next
            fast = fast.next.next
        
        while head is not fast:
            head = head.next
            fast = fast.next
        
        return head

```

---

Java 解法如下：

```Java

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode slow=head.next,fast=head.next.next;
        
        while(slow != fast) {
            if(fast==null || fast.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while(head!=fast) {
            head = head.next;
            fast = fast.next;
        }
        
        return head;
    }
}

```