
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