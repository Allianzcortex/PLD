
```Java

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = dummyHead;
            while(pre.next!=null && pre.next.val!=val)
                pre = pre.next;
            
            pre.next = pre.next.next;
            return dummyHead.next;
    }
}

```