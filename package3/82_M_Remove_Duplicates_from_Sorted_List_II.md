
Java Solution

```Java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while(cur!=null) {
            while(cur.next!=null && cur.next.val==cur.val)
                cur = cur.next;
            if(cur == pre.next){
                pre = pre.next;
                cur = cur.next;
            }
            else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

```

Python Solution:

For Python, I use a different approach : and this one is more intuitive than Java version
if we meet the case like `2 2 3 3`,then we will want to discard all of them
so we will only set pre when `cur.val != cur.next.val` 

```Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(-1)
        dummy.next = head
        pre,cur = dummy,head

        while cur and cur.next is not None:
            if(cur.val==cur.next.val):
                target = cur.val
                while(cur is not None and cur.val==target):
                    cur = cur.next
            else:
                pre = cur
                cur = cur.next
            pre.next = cur

        return dummy.next
```