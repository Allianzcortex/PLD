
```Java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null )
            return false;
        ListNode slow=head.next,fast=head.next.next;
        while(slow!=fast) {
            if(fast==null || fast.next==null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}
```