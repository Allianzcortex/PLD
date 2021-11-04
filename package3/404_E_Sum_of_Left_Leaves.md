
Problem description:

```

Given the root of a binary tree, return the sum of all left leaves.
 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000

```

Basic idea:

以下是 Python 解法：

首先是 recursive / dfs 解法：

假设 tree 有 N 个节点，高度为 H

```Python

class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:

        if not root:
            return 0

        res = 0
        if self.is_leaf(root.left):
            res += root.left.val

        res += self.sumOfLeftLeaves(root.left)
        res += self.sumOfLeftLeaves(root.right)
        
        return res
    
    
    def is_leaf(self,node):
        if node and node.left is None and node.right is None:
            return True

        return False

```

这种解法的时间复杂度是 O(N)，因为需要访问所有的节点

空间复杂度是 O(H)，因为要遍历 O(H) 层，如果是 balanced tree 就是 O(logN)层，是 scewed tree 就是 O(N)层


再其次是 BFS 解法：

```Python

class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        
        queue = deque([(root,False)])
        ans = 0
        
        while queue:
            curr,is_left = queue.popleft()
            
            if curr and not curr.left and not curr.right and is_left:
                ans += curr.val
            
            if curr.left:
                queue.append([curr.left,True])
            
            if curr.right:
                queue.append([curr.right,False])
        
        return ans

```

时间复杂度也是 O(N)

空间复杂度：O(N), or more specifically number of nodes on the level having maximum nodes.
最大 level 上的 node 的个数

---

以下是 Java 解法

Recursive solution

```Java

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        int sum = 0;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

```

Another idea is to set up a new method will add a new parameter `dir` like `public void solve(TreeNode root,boolean isLeft)`
And change this value when call the left/right node recursively.

Iterative Solution

```Java


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur==null)
                    continue;
                if(cur.left!=null && cur.left.left==null && cur.left.right==null)
                    sum += cur.left.val;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        
        return sum;
    }
}

```