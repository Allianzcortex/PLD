
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