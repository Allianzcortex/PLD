
Problem description:

```

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50

```

Basic idea: 这道题要考虑到如果 head.val==val 应该怎么办，所以一定要用 dummy node

Python 迭代解法如下：

```Python

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        
        dummy = ListNode(-1)
        dummy.next = head
        
        slow,fast = dummy,head
        
        while slow:
            if slow.next and slow.next.val==val:
                slow.next = slow.next.next
            else:
                slow = slow.next
            
        return dummy.next

```

Recursive:

```Java

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur=dummy;
        while(cur.next!=null) {
            if(cur.next.val==val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        
        return dummy.next;
        
    }
}

```

Iterative:

```Java

class Solution {
    public ListNode removeElements(ListNode head, int val) {
       if(head==null)
           return null;
        ListNode next = removeElements(head.next,val);
        if(head.val==val)
            return next;
        head.next=next;
        return head;
        
    }
}

```