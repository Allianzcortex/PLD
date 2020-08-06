
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

But it doesnot need to be so complex,just 