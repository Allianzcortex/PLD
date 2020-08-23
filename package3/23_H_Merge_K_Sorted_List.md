
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

`With heapq`