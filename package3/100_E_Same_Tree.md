
Problem description:

```

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

```

Basic idea:

是 easy 难度，直接比较 root.val 然后递归比较 left 和 right 即可

```Java

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null)
            return p==q;
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

```

Python Solution :

Solution 1 : recursive way

Time Complexity : O(n)
Space Complexity: O(n)

```Python
class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p is None or q is None:
            return p == q
        
        return p.val == q.val and self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)

```

Solution 2 : iterative way

```Python

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        stack = [(p,q)]
        while stack:
            p,q = stack.pop()
            if p is None and q is None:
                continue
            elif p is None or q is None:
                return False
            
            if p.val != q.val:
                return False
            stack.append((p.left,q.left))
            stack.append((p.right,q.right))

```