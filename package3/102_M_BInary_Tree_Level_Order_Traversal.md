
Problem Description:

```
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:
         3
       /   \
      9    20
          /   \
         15    7
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
```

So obviously there can be 2 solutions : recursive and iterative

For recursive solution 

```java

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        traverseTree(root,res,0);
        return res;
    }
    
    public void traverseTree(TreeNode root,List<List<Integer>> res,int level){
        if(root==null)
            return;
        if(level==res.size())
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        traverseTree(root.left,res,level+1);
        traverseTree(root.right,res,level+1);
        
    }
}

```

For iterative solution

```Python
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        queue,res = [],[]
        if root is None:
            return res
        queue.append((0,root))
        
        while queue:
            level,root = queue.pop(0)
            if level==len(res):
                res.append([])
            res[level].append(root.val)
            if root.left:
                queue.append((level+1,root.left))
            if root.right:
                queue.append((level+1,root.right))
        
        return res
```