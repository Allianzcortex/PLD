
My AC Solution

```Python
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(-1)
        dummy.next = head
        cur = dummy
        while(cur.next):
            while(cur.next.next and cur.next.val ==cur.next.next.val):
                cur.next = cur.next.next
            cur = cur.next
        
        return dummy.next

```

Another AC Solution is here:

```Python

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        dummy = ListNode(-1)
        dummy.next = head
        pre,cur = dummy,head
        
        while cur is not None:
            pre = pre.next
            while cur.next is not None and cur.val==cur.next.val:
                cur = cur.next
            pre.next = cur.next
            cur = cur.next
      
        
        return dummy.next
```

Very interesting. every time facing the new question there will be a new way to solve it.

But anyway the first solution is still most effective one.