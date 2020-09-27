
```
Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:

Start with the head as the current node.
Keep the first m nodes starting with the current node.
Remove the next n nodes
Keep repeating steps 2 and 3 until you reach the end of the list.
Return the head of the modified list after removing the mentioned nodes.

Follow up question: How can you solve this problem by modifying the list in-place?

Example 1:

input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
output: [1,5,9]

```

```Java

class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode cur = head,pre = head;
        int count = 0;
        while(cur!=null) {
            count = m;
            while(cur!=null && count-->0) {
                pre = cur;
                cur = cur.next;
            }
            
            count = n;
            while(cur!=null && count-->0) {
                cur = cur.next;
            }
            
            pre.next = cur;
        }
        pre.next = null; // not necessary actually......
        return head;
    }
}

```