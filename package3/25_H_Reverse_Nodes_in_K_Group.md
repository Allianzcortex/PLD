
Problem Description :

```
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]

```

Solution :

This is based on how to reverse the whole linked list :

```Python

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        """
        Input: head = [1,2,3,4,5], k = 2
        Output: [2,1,4,3,5]
        
        Input: head = [1,2,3,4,5], k = 3
        Output: [3,2,1,4,5]
        """
        
        dummy = ListNode(-1)
        
        dummy.next = head
        slow = dummy
        
        
        while True:

            fast = head            
            for _ in range(k):
                if fast is None:
                    slow.next = head
                    return dummy.next
                else:
                    fast = fast.next
            
            new_tail = head
            prev = None

            for _ in range(k):
                next_node = head.next
                head.next = prev
                prev = head
                head = next_node
                # temp = next_node.next
                # next_node.next = head
            
            slow.next = prev
            slow = new_tail
                
        
        return dummy.next

```

But I will need to check for discussions and see more other answers.