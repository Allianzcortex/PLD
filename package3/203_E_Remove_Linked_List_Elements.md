
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