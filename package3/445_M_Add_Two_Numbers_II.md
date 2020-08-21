
This is the most intuitive solution.
We just reverse the whole linkedlist and then it will become
`Add Two Numbers I`.

```Java
class Solution {
    
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
         
         ListNode dummy = new ListNode(-1);
         ListNode head = dummy;
         int carry = 0;
         while(l1!=null || l2!=null || carry>0) {
             if(l1!=null) {
                 carry += l1.val;
                 l1 = l1.next;
             }
             if(l2!=null) {
                 carry += l2.val;
                 l2 = l2.next;
             }
             
             ListNode temp = new ListNode(carry%10);
             carry /= 10;
             head.next = temp;
             head = head.next;
         }
         
         return reverseLinkedList(dummy.next);
    }
    
    public ListNode reverseLinkedList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode pre=null,cur=head;
        
        while(cur!=null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        
        return pre;
    }
}


```

And if we are not allowed to reverse the LinkedList,then the solution will become

```Java




```