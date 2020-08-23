
Java Solution

Use Two Pointer

```Java

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1=new ListNode(-1),l2=new ListNode(-1);
        ListNode cur1 = l1,cur2 = l2;
        while(head!=null) {
            if(head.val<x) {
                cur1.next=head;
                cur1 = cur1.next;
            } else {
                cur2.next=head;
                cur2=cur2.next;
            }
            
            head = head.next;
        }
        
       // set null to cur2.next. A very important step
        cur2.next = null;
        cur1.next = l2.next;
        return l1.next;
    }
}

```