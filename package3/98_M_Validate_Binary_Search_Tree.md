
Problem description:

```
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
```

Basic idea: 利用好 BST 的特性

BST 特性就是每一个节点的值都要大于最小值且小于最大值

Python Solution

```Python

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validate(root,None,None)
    
    def validate(self,root: TreeNode,min_value,max_value):
        if(root is None):
            return True
        # Must use is not None , if simplily use if(min_value and...)
        # it will fail the case when min_value is 0
        if(min_value is not None and root.val<=min_value):
            return False
        if(max_value is not None and root.val>=max_value):
            return False
        return self.validate(root.left,min_value,root.val) and self.validate(root.right,root.val,max_value)
    
```

Java Solution

```Java
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return valid(root,null,null);
    }
    
    public boolean valid(TreeNode root,Integer minValue,Integer maxValue) {
        if(root==null)
            return true;
        if(minValue!=null && root.val<=minValue)
            return false;
        if(maxValue!=null && root.val>=maxValue)
            return false;
        return valid(root.left,minValue,root.val) && valid(root.right,root.val,maxValue);
    }
}

```
