
Problem description:

```
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.

```

Basic idea:

这道题希望能找到一个时间复杂度小于 `O(n)` 的解法，解法如下：

每一次都计算 left_height 和 right_height，如果：

a. left_height==right_height，就说明最后一次空缺的节点在右子树，左子树是完全二叉树，总节点数量为 (2**left_height)

b. left_height!=right_height，就说明最后一次空缺的节点在左子树，右子树是完全二叉树，
并且 left_height = right_height + 1，右子树的总节点数量为 (2**right_height)

总的时间复杂度为 O(logN)*O(logN)，第一个 O(logN)是遍历左右，第二个 O(logN) 是计算
剩余的 `countNodes()`

Python 解法如下：

```Python

class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        
        if not root:
            return 0
        
        left_depth = self._get_height(root.left)
        right_depth = self._get_height(root.right)
        
        if left_depth==right_depth:
            return 2**left_depth + self.countNodes(root.right)
        else:
            return 2**right_depth + self.countNodes(root.left)
    
    
    def _get_height(self,root):
        if not root:
            return 0
        
        return 1 + self._get_height(root.left)

```