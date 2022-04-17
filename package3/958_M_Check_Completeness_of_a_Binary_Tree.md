
Problem description:

```

Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:


Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.

```

---

Idea :

这道题自己一开始的思路是：如果遇到 None，那么判断它的 index 是不是在这个 level 的最后一位，
这种思路有两个问题：

1. 假如在最后一个 level 前面的 level 空缺了最右的节点，那么无法检测出来
2. 在最后一个 level 之后还有一层全是 None 的 level，很难处理

更换一下思路，变成：如果遇到一个 None 节点之后还能遇到其他非 None 的节点，就说明这个二叉树不
完全

改写 Python 代码如下:

```Python

class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        
        if root is None:
            return False
        
        seenEmpty = False
        queue = deque([root])
        
        while queue:
            cur = queue.popleft()
            if cur is None:
                seenEmpty = True
                continue
            else:
                if seenEmpty:
                    return False
            
            queue.extend([cur.left,cur.right])
        
        return True

```

对应的 Java 代码如下：

```Java


class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        // Basic idea is that :
        // If we can meet a non-nulll node after we meet the first null node
        // it means it's invalid
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean hasMeetNull = false;
        TreeNode curr;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                curr = queue.poll(); 
                if(curr==null) {
                    hasMeetNull = true;
                } else {
                    if(hasMeetNull) {
                        return false;
                    }
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        
        return true;
    }
}

```