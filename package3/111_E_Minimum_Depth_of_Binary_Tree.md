
Below is Java solution : 

DFS

```Java

class Solution {
    private int minResult = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,1);
        return minResult;
    }

    public void dfs(TreeNode root,int level) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            minResult = Math.min(level,minResult);
        }

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

```

BFS

```Java

class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            for(int i=0;i<size;i++) {
                TreeNode curr = queue.poll();
                if(curr.left==null && curr.right==null)
                    return level;
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
        }

        return -1;
        
    }
}

```