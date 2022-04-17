
Porblem description:

```

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
Example 2:

Input: root = [0,null,1]
Output: [1,null,1]
Example 3:

Input: root = [1,0,2]
Output: [3,3,2]
Example 4:

Input: root = [3,2,4,1]
Output: [7,9,4,10]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
root is guaranteed to be a valid binary search tree.

```

Basic idea:

首先是自己的想法，按 `preorder` 的顺序来把节点吸入队列，然后从后往前
计算 prefix：

```Python

class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        
        """
        1. use inorder to get all nodes
        2. add values from end to begin
        """
        nodes = []
        
        self.dfs(root,nodes)
        
        prefix = nodes[-1].val
        
        for i in range(len(nodes)-2,-1,-1):
            nodes[i].val += prefix
            prefix = nodes[i].val
        
        return root
        
    
    def dfs(self,root,nodes):
        if not root:
            return
        
        self.dfs(root.left,nodes)
        nodes.append(root)
        self.dfs(root.right,nodes)

```

第二种方法就是在遍历过程中直接进行值的变更，类似 reverse inorder traverse
需要用到一个 global variable:

```Python

class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:

        self.prefix = 0
        self.dfs(root)
        
        return root
        
    
    def dfs(self,root):
        if not root:
            return
        
        self.dfs(root.right)
        root.val = self.prefix = self.prefix + root.val
        self.dfs(root.left)

```