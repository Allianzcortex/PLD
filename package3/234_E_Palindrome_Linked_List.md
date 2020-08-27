
Overall the basic idea is :

// 1 find the middle
// 2 reverse linked list

Java Solution : 

```Java

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return compareLinkedList(head,reverseLinkedList(slow));
        
    }
    
    // reverse method 1
    // public ListNode reverseLinkedList(ListNode head) {
    //     if(head==null || head.next==null)
    //         return head;
    //     ListNode nextHead = reverseLinkedList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return nextHead;
    // }
    
    // reverse method 2
    public ListNode reverseLinkedList(ListNode head) {
    // pre   cur
        // 1 -2 -3 4
        ListNode pre=null,cur=head;
        while(cur!=null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        
        return pre;
    }
    
    public boolean compareLinkedList(ListNode h1,ListNode h2) {
        while(h2!=null) {
            if(h1.val!=h2.val)
                return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return true;
    }
}

```

---

Python Solution : 

```Python


```