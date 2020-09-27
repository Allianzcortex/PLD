
This is my AC solution, idea is the same,but for god's sake,how can
it be implemented.....

```Java

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode root = null;
        for(ListNode node=head;node!=null;) {
            ListNode temp = node.next;
            node.next = null;
            root = insertNewNode(root,node);
            node = temp;
        }
        
        return root;
    }
    
    public ListNode insertNewNode(ListNode head,ListNode newNode) {
        if(head==null)
            return new ListNode(newNode.val);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.val<newNode.val) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return dummy.next;
    }
}

```

Iterative Java Insertion sort :

```Java
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode pre=null;
    
        while(head!=null) {
            pre = head.next;
            ListNode p = dummy;
            while(p.next!=null && p.next.val<head.val) 
                p = p.next;
            
            head.next = p.next;
            p.next = head;
            head = pre;
        }
        
        return dummy.next;
    }
}

```

TODO : Add Python Solution