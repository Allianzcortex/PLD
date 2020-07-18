
```Java
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null || k<=0)
            return null;
        ListNode pre=head,next=head;
        //  while(k-->0) not while(k--)
        //  This is Java not Python (:
        while(k-->0)
            next = next.next;
        while(next!=null) {
            next = next.next;
            pre = pre.next;
        }

        return pre;
    }
}

```