
Problem description:

```
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000

```

Basic idea:

很好的一道题目，要考虑到问题的完整性

Java Solution :

```Java

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        // 注意是一个 solvePath 和两个 pathSum 方法，这样可以解决 [1,null,2,null,3,null,4,null,5],3 的情况
        // 1-2 和 3 都满足和为 3 的情况
        return solvePath(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    
    public int solvePath(TreeNode root,int sum) {
        int res=0;
        if(root==null)
            return res;
        if(root.val==sum)
            res+=1;

        return res+solvePath(root.left,sum-root.val)+solvePath(root.right,sum-root.val);
    }
}


```

TODO : Add iterative and Python solution