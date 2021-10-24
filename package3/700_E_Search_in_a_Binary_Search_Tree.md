
Problem description:

```
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107

```

Basic idea:

这道题是 easy 题，所以也有 easy 难度的解法，就是利用 BST 的特性来递归迭代，
Python 解法如下：

```Python

class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        
        while root and root.val!=val:
            root = root.left if root.val>val else root.right
        
        return root
```

但同样也有 Medium 难度的解法，就是利用 `stack` 来模拟 preorder，这点后续再做


Java Solution :

1. Recursive

```Java
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int sum = 0;
        
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if(cur==null)
                continue;
            if(cur.val<L)
                s.push(cur.right);
            else if(cur.val>R)
                s.push(cur.left);
            else {
                sum+=cur.val;
                s.push(cur.left);
                s.push(cur.right);
            }
        }
        
        return sum;
    }
}

```

2. Iterative

```Java

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur==null)
                continue;
            if(cur.val==val)
                return cur;
            else if(cur.val<val) {
                stack.push(cur.right);
            } else {
                stack.push(cur.left);
            }
        }
        
        return null;
    }
}

```

And a simple recursive solution:

```Java

public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }

```