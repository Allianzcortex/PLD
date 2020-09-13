
Solution 1 : Iterative Solution

```Java

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curhead = dummy;
        
        while(curhead.next!=null && curhead.next.next!=null) {
            ListNode swap1 = curhead.next;
            ListNode swap2 = curhead.next.next;
            curhead.next = swap2;
            swap1.next = swap2.next;
            // 一开始顺序写反了
            swap2.next = swap1;
            curhead = swap1;
        }
        
        return dummy.next;
    }
}

```

Solution 2 : Recursive Solution

```Java

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextHead = swapPairs(head.next.next);
        ListNode temp = head.next;
        head.next = nextHead;
        temp.next = head;
        
        return temp;
    }

```