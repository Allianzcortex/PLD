
Interesting & Classic problem

Java Solution:

```Java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0;i<m-1;i++)
            pre = pre.next;
        
        /**
       pre  cur  then
        1 -> 2 -> 3 -> 4 -> 5
        
        pre      cur  then
        1 -> 3 -> 2 -> 4 -> 5
        
        pre           cur then
        1 -> 4 -> 3 -> 2 -> 5
        
        **/
        
        ListNode cur = pre.next;
        ListNode then = cur.next;
        
        for(int i=0;i<n-m;i++) {
            System.out.println(cur.val);
            ListNode temp = then.next;
            then.next = pre.next;
            pre.next = then;
            cur.next = temp;
            then = temp;
        }
        
        return dummy.next;
    }
}

```

---

---

Python Solution

```Python

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        dummy = pre = ListNode(-1)
        dummy.next = head
        for i in range(m-1):
            pre = pre.next
        
        cur,then = pre.next,pre.next.next
        for i in range(n-m):
            temp = then.next
            then.next = pre.next
            pre.next = then
            cur.next = temp
            then = temp
        
        return dummy.next

```