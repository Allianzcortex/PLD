
Problem description:

```

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

```

Idea:

就是定义一个 target，把所有小于它的元素放在左边，把大于它的元素放在右边

思路是用 two pointer，用两个 dummy head,两个节点分别是 small , big

最重要的一点是因为我们最后要用 `small.next = l2.next` 所以我们不关心 small 后面接的是什么节点
但我们需要用 `big.next = None` 来把后半部分的尾巴处理掉

Python Solution :

```Python

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head:
            return None
        
        l1,l2 = ListNode(-1),ListNode(-1)
        
        small,big = l1,l2
        
        while head:
            if head.val<x:
                small.next = head
                small = small.next
            else:
                big.next = head
                big = big.next
            
            head = head.next
        
        big.next = None # very important step
        small.next = l2.next
        return l1.next

```

Java Solution

Use Two Pointer

```Java

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1=new ListNode(-1),l2=new ListNode(-1);
        ListNode cur1 = l1,cur2 = l2;
        while(head!=null) {
            if(head.val<x) {
                cur1.next=head;
                cur1 = cur1.next;
            } else {
                cur2.next=head;
                cur2=cur2.next;
            }
            
            head = head.next;
        }
        
       // set null to cur2.next. A very important step
        cur2.next = null;
        cur1.next = l2.next;
        return l1.next;
    }
}

```