
My initial thought is like robber proble I&II,you can either choose
1 or 2,but apprently it cannot pass the cases like 

```
   4
 /
1 
/
2
/
3
```

#### failure solution

```Java

class Solution {
    public int rob(TreeNode root) {
        int pre1=0,pre2=0;
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur==null)
                    continue;
                queue.offer(cur.left);
                queue.offer(cur.right);
                if(flag)
                    pre1+=cur.val;
                else
                    pre2+=cur.val;
            }
            flag = !flag;
        }
        return Math.max(pre1,pre2);
    }
}

```

A better way will be :

```Java

class Solution {
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int sum = 0;
        if(root.left!=null)
            sum+=(rob(root.left.left)+rob(root.left.right));
        if(root.right!=null)
            sum+=(rob(root.right.left)+rob(root.right.right));
        
        return Math.max(sum+root.val,rob(root.left)+rob(root.right));
    }
}

```

Absolutely we can use Map as memorization to improve the speed :

```Java

class Solution {
    public int rob(TreeNode root) {
        return subRob(root,new HashMap<TreeNode,Integer>());
    }
    
    public int subRob(TreeNode root,Map<TreeNode,Integer> map) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        
        int sum = 0;
        if(root.left!=null)
            sum+=(subRob(root.left.left,map)+subRob(root.left.right,map));
        if(root.right!=null)
            sum+=(subRob(root.right.left,map)+subRob(root.right.right,map));
        sum = Math.max(root.val+sum,subRob(root.left,map)+subRob(root.right,map));
        map.put(root,sum);
        return sum;
    }
}

```

And how do we continue to improve the efficiency ? here is the next new answer :

check the link : https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem

```Java


```

TODO : add a more effective answer later and add Python solution

这里加一个用 Python 的 memcache 解法：

```Python

class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        
        cache = {}
        return self.dfs(root,cache)
    
    def dfs(self,root,cache):
        if root is None:
            return 0
        
        if root in cache:
            return cache[root]
        
        sum_1 = root.val
        if root.left:
            sum_1 += (self.dfs(root.left.left,cache)+self.dfs(root.left.right,cache))
        
        if root.right:
            sum_1 += (self.dfs(root.right.left,cache)+self.dfs(root.right.right,cache))
        
        sum_2 = self.dfs(root.left,cache) + self.dfs(root.right,cache)
        
        cache[root] = max(sum_1,sum_2)
        return cache[root]
            
```

但还不是最正统的 DP tho...