
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