The classic problem.

Solution 1 :iterative

```Java
class Solution {
    public ListNode reverseList(ListNode head) {
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