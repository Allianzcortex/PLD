
Classic Problem

Solution1 Iterative

```Java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        // head head.next
        // pre cur 
        ListNode pre=null,cur=head;
        while(head!=null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;       
    }
}
```

---

Solution2 Recursive

```Java

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        // head nextHead
        ListNode nextHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
        
    }
}

```

---

Python Solution :

Recursive Solution:

```Python

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        next_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        
        return next_head

```

Iterative Solution :

```Python

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        prev,cur = None,head
        
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        
        return prev

```