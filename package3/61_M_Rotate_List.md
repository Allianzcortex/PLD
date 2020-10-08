
Java Solution , it should be pretty straight-forward:

Just use `1->2->3->4->5` as an example.

```
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
```

```java

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        
        k = k % getLen(head);
        
        ListNode first=head,second=head;
        for(int i=0;i<k;i++)
            second = second.next;
        while(second.next!=null) {
            first = first.next;
            second = second.next;
        }
        
        if(first==second)
            return head;
        
        ListNode tempHead = first.next;
        first.next = null;
        second.next = head;
        return tempHead;
        
    }
    
    public int getLen(ListNode head) {
        int len = 0;
        while(head!=null) {
            len += 1;
            head = head.next;
        }
        
        return len;
    }
}

```