
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

---

For Python Solution :

Recursive Solution:

```Python

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        # swap the nodes
        next_node = self.swapPairs(head.next.next)
        temp = head.next
        temp.next = head
        head.next = next_node
        
        return temp
```

Iterative Solution:

```Python
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        dummy = ListNode()
        dummy.next = head
        cur_node = dummy
        
        while head is not None and head.next is not None:
            """
                1     2  3   4
           cur  head 
                2     1  3   4
                    cur head
                2     1  4   3
                             cur head(None)
             """
            temp = head.next.next
            next_node = head.next
            next_node.next = head
            head.next = temp
            cur_node.next = next_node
            
            cur_node = head
            head = temp

        return dummy.next


```