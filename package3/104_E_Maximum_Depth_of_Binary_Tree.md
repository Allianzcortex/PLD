
Problem Description :

```

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1
 

```

Below is Java Solution :

Recursive Solution :

```Java

class Solution {
    public int maxDepth(TreeNode root) {
         if(root==null)
           return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

```

Iterative Solution :

```Java

class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            
            depth+=1;
        }
        
        return depth;
    }
}

```

---

Next is Python solution :

```Python

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        return 1+max(self.maxDepth(root.left),self.maxDepth(root.right))

```