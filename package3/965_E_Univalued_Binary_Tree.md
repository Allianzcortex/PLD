
Problem description:

```

A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

 

Example 1:


Input: root = [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: root = [2,2,2,5,2]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val < 100

```

Basic idea:

下面这三种解法基本就是所有的解法了

对递归型：有两种
对迭代型：有一种，用 queue

Recursive Solution :

method 1 :

```Java
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        return traverse(root,root.val);
    }
    
    public boolean traverse(TreeNode root,int target) {
        if(root==null)
            return true;
        if(root.val!=target)
            return false;
        
        return traverse(root.left,target) && traverse(root.right,target);
        
    }
}


```

method 2 : compare tree directly

```Java

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        if(root.left!=null && root.val!=root.left.val)
            return false;
        if(root.right!=null && root.val!=root.right.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}

```


Iterative Solution

```Java

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int target = root.val;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur.val!=target)
                    return false;
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
        }
        
        return true;
    }
}

```