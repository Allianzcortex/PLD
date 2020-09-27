
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

TODO: check discussion for other solutions & Python solution