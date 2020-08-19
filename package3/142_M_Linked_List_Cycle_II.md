```
Assume the distance from head to the start of the loop is x1
the distance from the start of the loop to the point fast and slow meet is x2
the distance from the point fast and slow meet to the start of the loop is x3
What is the distance fast moved? What is the distance slow moved? And their relationship?

x1 + x2 + x3 + x2
x1 + x2
x1 + x2 + x3 + x2 = 2 (x1 + x2)
Thus x1 = x3
```

Find the connected dot where slow meets fast.
And when head==fast, then the node where they meet will be the result.

```Java

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode slow=head.next,fast=head.next.next;
        boolean isCycle = false;
        
        while(slow != fast) {
            if(fast==null || fast.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while(head!=fast) {
            head = head.next;
            fast = fast.next;
        }
        
        return head;
    }
}

```