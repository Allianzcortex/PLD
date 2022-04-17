
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

Idea :

很直接和经典的题，

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

下面是 Golang Solution :

递归解法需要自定义一个 `max` 函数：

```Go

func maxDepth(root *TreeNode) int {
    
    if root == nil {
        return 0
    }
    
    return max(maxDepth(root.Left),maxDepth(root.Right)) + 1
}


func max(a int,b int) int {
    if(a>b){
        return a;
    }
    return b;
}

```

而对迭代解法，考虑到 Golang Slice 的切片陷阱，或者提前计算 length，或者
中间用一个 nextStack[] 来存储所有的计算结果：

a) 提前计算 length 如下，和 Java 很像：

```Go

func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    depth := 0
    stack := []*TreeNode{root}
    
    for len(stack)!=0 {
        depth += 1
        length := len(stack)
        for i:=0;i<length;i++ {
            
            node := stack[0]
            if node.Left != nil {
                stack = append(stack,node.Left)
            }
            
            if node.Right != nil {
                stack = append(stack,node.Right)
            }
            
            stack = stack[1:]
        }
    }
    
    return depth
    
}

```

b) 中间用一个缓存来计算结果：

```Go

func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    depth := 0
    stack := []*TreeNode{root}
    
    for len(stack)!=0 {
        depth += 1
        nextStack := []*TreeNode{}
        for _,v := range stack {
            if v.Left != nil {
                nextStack = append(nextStack,v.Left)
            }
            
            if v.Right != nil {
                nextStack = append(nextStack,v.Right)
            }
        }
        
        stack = nextStack
    }
    
    return depth
    
}

```