
This should be a pretty straight-forward solution,how can I
use so much time ? ? ? 

```Java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return compare(head,root) || (root.left!=null && isSubPath(head,root.left)) || (root.right!=null && isSubPath(head,root.right));
    }
    
    public boolean compare(ListNode head,TreeNode root) {
        if(head==null)
            return true;
        if(root==null)
            return false;
        
        if(head.val!=root.val)
            return false;
        return compare(head.next,root.left) || compare(head.next,root.right);
        }
}

```

---

While another solution is to use `KMP/DP` , its really out of scope......