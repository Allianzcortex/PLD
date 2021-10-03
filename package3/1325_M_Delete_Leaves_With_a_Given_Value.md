
Problem description:

```

Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).

 

Example 1:



Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left). 
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
Example 2:



Input: root = [1,3,3,3,2], target = 3
Output: [1,3,null,null,2]
Example 3:



Input: root = [1,2,null,2,null,2], target = 2
Output: [1]
Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
Example 4:

Input: root = [1,1,1], target = 1
Output: []
Example 5:

Input: root = [1,2,3], target = 1
Output: [1,2,3]

```

这道题是 Medium 难度，但自己做的时候(是因为晚上思路不清晰吗？)陷入到一个
死循环里，就是：

如果发现一个叶子节点满足条件(ie `root.left is None and root.right is None
and root.val==target`)，那么怎么办？

自己一开始想的是这个时候设置 `root=None`，但这样并不能改变这棵树，应该是设置
`root.parent.child=None`，顺着这个思路推下去可以知道合理的代码是：

`root.left = self.removeLeafNodes(root.left,target)`

所以最后循环递归的解法如下：

```Python

class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        
        if root.left:
            root.left = self.removeLeafNodes(root.left,target)
        
        if root.right:
            root.right = self.removeLeafNodes(root.right,target)
        
        if root.left is None and root.right is None and root.val==target:
            return None
        else:
            return root

```