
Problem Description:

```

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

```

Java Solution

```Java

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=0;i<n;i++)
            second = second.next;
        while(second!=null && second.next!=null){
            first = first.next;
            second = second.next;
        }
        // 下面的问题是难点，自己花了很多时间试着在 first 和 second 之间建立联系
        // 最后发现其实没有必要，直接把 first.next.next 赋值给 first.next 就够了
        // if(second.next==null && (first==second || first.next==second))
        //     second = null;
        // first.next = second;
        first.next = first.next.next;
        return dummy.next;
        
    }
}

```

Python Solution :

自己一开始的解法如下：

```Python

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(-1)
        
        dummy.next = head
        slow,fast = head,head
        
        for _ in range(n):
            fast = fast.next
        
        while fast is not None and fast.next is not None:
            fast = fast.next
            slow = slow.next
        
        if slow is head:
            dummy.next = head.next
        else:
            slow.next = slow.next.next
        
        return dummy.next
```

这种方法并不好，因为定义的双指针：slow 和 fast 都指向 head，这样面对下面的情况：

[1,2] 1
[1,2] 2

就都会出现 slow == head 的情况

解决方式就是定义 dummy node，把双指针都指向 dummy：

```Python

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(-1)
        
        dummy.next = head
        slow,fast = dummy,dummy
        
        for _ in range(n):
            fast = fast.next
        
        while fast.next is not None:
            fast = fast.next
            slow = slow.next

        slow.next = slow.next.next
        
        return dummy.next

```

