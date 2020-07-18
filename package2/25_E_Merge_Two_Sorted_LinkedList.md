
```Java

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null && l2==null)
            return null;
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        
        ListNode head=new ListNode(-1);
        ListNode pre = head;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val){
                head.next=l1;
                l1 = l1.next;
            } else {
                head.next=l2;
                l2=l2.next;
            }
            head = head.next;
        }

        head.next=(l1==null?l2:l1);
        return pre.next;
    }
}


```