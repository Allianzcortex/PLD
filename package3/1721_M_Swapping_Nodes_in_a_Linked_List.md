
Problem description:

```
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100

```

Basic idea:

自己一开始把它想的太复杂了，一看到交换就想找到两个节点然后用复杂的操作来交换，还写出了如下的
`helper` 代码：

```Python

def _helper(self,node1,node2):
    """
    before:
    node1->target1->node2->others
    
    after:
    node1->node2->target1->others
    
    """
    if node1.next is node2:
        return
    
    target,next_element = node1.next, node2.next
    node1.next = node2
    node2.next = target
    target.next = next_element
```

其实只需要找到两个节点之后直接交换值就可以了，代码如下：

```Python

class Solution:
    def swapNodes(self, head: ListNode, k: int) -> ListNode:
        """
        Find the prev node of first kth node
        Find the node of last kth node
        """
        slow = fast = head
        
        # find the first kth 
        for _ in range(k-1):
            fast = fast.next
        
        first = fast
        
        # find the last kth
        while fast.next is not None:
            fast = fast.next
            slow = slow.next
        
        second = slow
        first.val,second.val = second.val,first.val
        return head

```