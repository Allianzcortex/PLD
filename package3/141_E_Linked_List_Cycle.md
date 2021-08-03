
Problem description:

```

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

```

基本思路：

思路 1：用一个 hash 表来存储已经访问过的节点

思路 2：用 slow=slow.next , fast=fast.next.next 看双指针
       能否相遇


Python Solution 思路 1：

```Python

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        maps = {}
        
        while head:
            if head in maps:
                return True
            
            maps[head] = True
            head = head.next
        
        return False

```

Python Solution 思路 2：

```Python

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head or not head.next:
            return False
        
        slow,fast = head,head.next
        
        while slow is not fast:
            
            if fast is None or fast.next is None:
                return False
            
            slow,fast = slow.next,fast.next.next
        
        return True

```


```Java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null )
            return false;
        ListNode slow=head.next,fast=head.next.next;
        while(slow!=fast) {
            if(fast==null || fast.next==null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}
```