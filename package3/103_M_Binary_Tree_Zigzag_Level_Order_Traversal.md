
Problem Description:

```
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

```

zigzag 思路应该是很经典的，根据 level 来判断：

1. Recursive Solution

```Java

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(root,1,res);
        return res;
    }
    
    public void solve(TreeNode root,int level,List<List<Integer>> res) {
        if(root==null)
            return;
        if(level>res.size())
            res.add(new ArrayList<Integer>());
        if(level%2==1) {
            // from left to right
            res.get(level-1).add(root.val);
        } else {
            // from right to left
            res.get(level-1).add(0,root.val);
        }
        
        solve(root.left,level+1,res);
        solve(root.right,level+1,res);
        
    }
}

```

2. Iterative Solution

```Java

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean direction = true;
        
        while(!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode cur = queue.poll();
                if(direction) {
                    // from left to right
                    curr.add(cur.val);
                } else {
                    // from right to left
                    // TODO a better naming for queue and node,curr and cur are confusing
                    curr.add(0,cur.val);
                }
                
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            
            direction=!direction;
            res.add(curr);
        }
        
        return res;
    }
}


```

---

Below is Python solution :

Recursive solution:

```Python

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        
        res = []
        self.dfs(root,res,0)
        
        return res
    
    def dfs(self,root,res,level):
        
        if root is None:
            return
        
        if level == len(res):
            res.append([])
        
        if level%2==0:
            res[level].append(root.val)
        else:
            res[level].insert(0,root.val)
        
        self.dfs(root.left,res,level+1)
        self.dfs(root.right,res,level+1)

```

Iterative solution:

```Python


class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return []
        
        queue = deque([root])
        res = []
        level = 0
        
        while queue:
            size = len(queue)
            res.append([])
            for _ in range(size):
                node = queue.popleft()
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                
                if level%2==0:
                    # from left->right
                    res[-1].append(node.val)
                else:
                    res[-1].insert(0,node.val)
                
            level += 1

        return res        

```