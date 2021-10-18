
Problem description:

```

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []

```

Basic idea : 就是非常直观的解决方法，DFS，如果遇到
sum == target 并且这个子节点是叶子结点的话就返回结果：

```Python

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        if not root:
            return []
        
        res = []
        
        self.dfs(root,targetSum,0,[],res)
        
        return res
    
    def dfs(self,root,targetSum,curSum,path,res):
        if root is None:
            return
        
        if root.left is None and root.right is None and curSum+root.val==targetSum:
            
            # 注意 append 和 pop 必须对应，所以这里 path 不能 append
            res.append(path[:]+[root.val])
            return
        
        path.append(root.val)
        self.dfs(root.left,targetSum,curSum+root.val,path,res)
        self.dfs(root.right,targetSum,curSum+root.val,path,res)
        path.pop()

```

Just add Basic DFS solution

```Java

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        traverse(root,sum,res,path);
        return res;
    }

    public void traverse(TreeNode root,int sum,List<List<Integer>> res,List<Integer> path) {
        if(root==null)
            return;
        sum -= root.val;
        if(root.left==null && root.right==null && sum==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(root.left!=null) {
            path.add(root.left.val);
            traverse(root.left,sum,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            path.add(root.right.val);
            traverse(root.right,sum,res,path);
            path.remove(path.size()-1);
        }
    }
}

```

Will add iterative / Python solution later