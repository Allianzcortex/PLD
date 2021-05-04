

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