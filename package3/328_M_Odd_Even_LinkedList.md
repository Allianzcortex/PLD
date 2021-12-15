
Problem description:

```

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

n == number of nodes in the linked list
0 <= n <= 104
-106 <= Node.val <= 106

```

Basic idea:

这是自己
This is what I want to do the 1st time...and its completely a failure.

Why ? because the original List is changed when we iterate over the oddCur. So it will not be what we want when we try to iterate over the evenCur.

Take `1->2->3->4->5` as an example. After iterating the odd(`1->3->5`),
the even will be `2->3->5` but not `2->3->4`.some information is abandoned.

So we must do them at the same time.

Failed Solution :

```Java

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode oddHead = new ListNode(-1),evenHead = new ListNode(-2);
        ListNode oddCur = head;
        ListNode evenCur = head.next;
        oddHead.next = oddCur;
        evenHead.next = evenCur;
        
        while(oddCur.next!=null && oddCur.next.next!=null) {
            if(oddCur.next!=null)
                oddCur.next = oddCur.next.next;
            oddCur = oddCur.next;
        }

        while(evenCur!=null) {
            if(evenCur.next!=null) {
                evenCur.next = evenCur.next.next;
            }
            evenCur = evenCur.next;
        }
       
        oddCur.next = evenHead.next;
        return oddHead.next;
        
    }
}
```

Right Solution :

```Java

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode oddCur = head;
        ListNode evenCur = head.next;
        ListNode evenHead = head.next;
        
        while(evenCur!=null && evenCur.next!=null) {
            oddCur.next = oddCur.next.next;
            oddCur = oddCur.next;
            evenCur.next = evenCur.next.next;
            evenCur = evenCur.next;
        }
        
        oddCur.next = evenHead;
        return head;
    }
}

```

TODO Add Python Solution