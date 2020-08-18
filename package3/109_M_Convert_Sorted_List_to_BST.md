
This is my initial java solution,
find the middle and construct the tree recursively.
The key is to handle the case with only two elements like `1->2`

```Java

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        
        ListNode slow=head,fast=head.next.next;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rightNode=slow.next;
        TreeNode root = new TreeNode(rightNode.val);
        slow.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightNode.next);
        return root;
    }
}

```

---

This is a better solution :

```Java

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        
        ListNode slow=head,fast=head,pre=null;
        while(fast!=null && fast.next!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}

```

---

This is the Python solution

```Python

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head:
            return None
        if not head.next:
            return TreeNode(head.val)
        
        slow,fast,pre = head,head,None
        while(fast and fast.next):
            pre = slow
            slow = slow.next
            fast = fast.next.next
        
        pre.next = None
        root = TreeNode(slow.val)
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(slow.next)
        return root

```