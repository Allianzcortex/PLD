
Basically idea is the same : 

1. find the middle
2. reverse the 2nd half
3. combine 2 parts together

This is the fist solution : my implementation

```Java
/**
    1->2->3->4    
    1->2->3->4->5
    1->2
    5->4->3
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode slow = head,fast = head;
        
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode p1 = head;
        ListNode p2 = reverseLinkedList(slow.next);
        slow.next = null;
        boolean flag = true;
        while(p1!=null && p2!=null) {
            if(flag) {
                p1 = p1.next;
                head.next = p2;
                head = head.next;
                flag = !flag;
            } else {
                p2 = p2.next;
                head.next = p1;
                head = head.next;
                flag = !flag;
            }
        }
        
        
    }
    
    public ListNode reverseLinkedList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

```

This is the 2nd implementation : 

https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps/155674

And this is the one we use HashMap :

https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps/232531