
Problem description:

```
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

 

Example 1:


Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
Example 2:


Input: root = [5,1,7]
Output: [1,null,5,null,7]
 

Constraints:

The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000

```

Basic idea:

使用 Python 的递归解法：

```Python

class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        
        self.prev=self.leftMost=None
        
        self.traverse(root)
        
        return self.leftMost
    
    def traverse(self, root):
        
        if not root:
            return
        
        self.traverse(root.left)
        if self.prev!=None:
            root.left = None
            self.prev.right = root
        
        if self.prev is None:
            self.leftMost = root
        
        self.prev = root
        self.traverse(root.right)

```

1. Recursive Solution :

#### Well,it just seems easy to understand,but revursive solution
is not so straight-forward. You need to know the real meaning of tail
or you will easily forget it next time.

```Java

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return traverse(root,null);
    }
    
    public TreeNode traverse(TreeNode root,TreeNode tail) {
        if(root==null)
            return tail;
        TreeNode res = traverse(root.left,root);
        root.left = null;
        root.right = traverse(root.right,tail);
        return res;
        
    }
}

```

2. Iterative Solution :

```Java
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(-1);
        TreeNode head = dummy;
        
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            head.right = root;
            head = head.right;
            root = root.right;
            head.left = null;
        }
        
        return dummy.right;
    }
}

```

TODO : Add Python Solution