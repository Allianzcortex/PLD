
Problem description:

```

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 

Example 1:


Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
Example 2:


Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
Example 3:


Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 

Constraints:

The number of nodes in the list is an even integer in the range [2, 105].
1 <= Node.val <= 105

```

Basic idea:

这道题描述的很直观，就是找到终点后然后把前半部分和后半部分的点结合起来：

Python 一开始解法如下，其中 reverse 部分是用 `[::-1]` 取巧来生成的

```Python

class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        """
        1->2->3->4 , we have 4 nodes
        
        
        """
        # guarantee that the even integer in the range [2,10^5]
        
        first,second = head,head
        
        while second and second.next:
            first = first.next
            second = second.next.next
        
        # first node is the start of second half
        res1,res2 = [],[]
        while first:
            res1.append(head.val)
            head = head.next
            
            res2.append(first.val)
            first = first.next
        
        res2 = res2[::-1]
        return max(res1[i]+res2[i] for i in range(len(res1)))

```

比较清晰的一种思路是用 `reverseLinkedList()` 来逆转第二部分：

```Python

class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:

        # guarantee that the even integer in the range [2,10^5]
        
        second_half = self.getMiddle(head)
        second_half = self.reverseList(second_half)
        return self.getMax(head,second_half)
            
    
    def getMiddle(self,head):
        
        first,second = head,head
        
        while second and second.next:
            first = first.next
            second = second.next.next
        
        return first
    
    def reverseList(self,head):
        
        if not head or not head.next:
            return head
        
        next_node = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        
        return next_node
    
    def getMax(self,head1,head2):
        
        res = float('-inf')
        while head2:
            res = max(res,head1.val+head2.val)
            head1 = head1.next
            head2 = head2.next
        
        return res

```

对应的 Golang 解法如下，其中用了不同的方法来 `reverse LinkedList()` :

```Golang

func pairSum(head *ListNode) int {
    
    secondHalf := getMiddle(head)
    secondHalf = reverseList(secondHalf)
    
    return getMax(head,secondHalf)
}


func getMiddle(head *ListNode) *ListNode {
    
    first,second := head,head
    
    for second!=nil && second.Next!=nil {
        second = second.Next.Next
        first = first.Next
    }
    
    return first
}

func reverseList(head *ListNode) *ListNode {
    
    // 注意不能直接定义为 prev:= nil
    // 会造成 untyped nil 的错误
    prev,cur := &ListNode{},head
    
    for cur!=nil {
        nextNode := cur.Next
        cur.Next = prev
        prev = cur
        cur = nextNode
    }
    
    return prev
}

func getMax(head1,head2 *ListNode) int {
    
    res:=0
    
    for head2!=nil {
        res = max(res,head1.Val+head2.Val)
        head1 = head1.Next
        head2 = head2.Next
    }
    
    return res
}

func max(a,b int) int {
    if(a>b) {
        return a
    }
    
    return b
}

```