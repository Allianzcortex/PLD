
This is my Solution, pretty straight-forward

```Java

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            if(l1!=null){
                carry+=l1.val;
                l1=l1.next;}
            if(l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            
            ListNode temp=new ListNode(carry%10);
            head.next =temp;
            head = head.next;
            carry /= 10;
        }
        return dummy.next;
    }
}

```

Here update the Python solution :

```Python

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        dummy = ListNode(-1)
        head = dummy
        
        while l1 or l2 or carry != 0 :
            if l1 is not None:
                val1 = l1.val
                l1 = l1.next
            else:
                val1 = 0
                
            if l2 is not None:
                val2 = l2.val
                l2 = l2.next
            else:
                val2 = 0

            sum_ = val1 + val2 + carry
            
            carry = sum_ // 10
            head.next = ListNode(sum_ % 10)
            head = head.next
        
        return dummy.next

```

