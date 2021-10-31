
Problem description:

```
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

```

Java Solution

This is my initial solution :

```Java

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // build the min heap
        if(lists==null || lists.length==0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(n1,n2)->(n1.val-n2.val));
        for(ListNode node:lists)
            if(node!=null)
                pq.add(node);
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode newNode = pq.poll();
            cur.next = newNode;
            cur = cur.next;
            if(newNode.next!=null)
                pq.add(newNode.next);
        }
        
        return dummy.next;
    }
}

```

While actually `adding node part` can be simplified :

```Java
ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(pq.size()!=0) {
            cur.next=pq.poll();
            cur = cur.next;
            if(cur.next!=null)
                pq.add(cur.next);
        }

```

---

Python Solution:

下面两种解法时间复杂度都是 O(NLogK)，N 是 total elements，因为对每个 element 在 merge 都要
过一遍，而 K 则是 len(list)，一共有 K 个 NodeHead

首先还是上用 heapq 的解法：

这里仍然有两种解法：第一种是只压入节点的值，压出来的时候 new 一个新的节点。第二种是压入整个节点。

第一种解法如下：

```Python

from heapq import heappush,heappop
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        queue = []
        
        for l in lists:
            while l:
                heappush(queue,l.val)
                l = l.next
        
        dummy = ListNode(-1)
        head = dummy
        
        while queue:
            curr = heappop(queue)
            new_node = ListNode(curr)
            head.next = new_node
            head = head.next
        
        return dummy.next

```

第二种解法如下：

其中因为 Python 没办法像 Java 一样自定义比较方法，所以无法直接比较节点，只能按照
`(val,id)` 的方式压入

```Python

from heapq import heappush,heappop
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        queue = []
        
        for l in lists:
            while l:
                heappush(queue,(l.val,id(l),l))
                l = l.next
        
        dummy = ListNode(-1)
        head = dummy
        
        while queue:
            _,_, curr = heappop(queue)
            head.next = curr
            head = head.next
        
        return dummy.next

```

第二种解法则是利用 Merge 2 Sorted List，之后再 divde-and-conque 解决，解法如下：

```Python

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        if not lists:
            return None
        
        length = len(lists)
        
        while length!=1:
            for i in range(length//2):
                lists[i] = self._merge_2_lists(lists[i*2],lists[i*2+1])
            if length%2==1:
                lists[length//2] = lists[length-1]
                length = length//2+1
            else:
                length = length//2
        
        return lists[0]
    
    def _merge_2_lists(self,head1,head2):
        
        dummy = ListNode(-1)
        head = dummy
        
        while head1 and head2:
            if head1.val<head2.val:
                head.next = head1
                head1 = head1.next
            else:
                head.next = head2
                head2 = head2.next
                
            head = head.next
        
        head.next = head1 or head2
        return dummy.next

```

