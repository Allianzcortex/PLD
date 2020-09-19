
Recursive Solution :

```Java

class Solution {
    public int maxDepth(TreeNode root) {
         if(root==null)
           return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

```

Iterative Solution :

```Java

class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            
            depth+=1;
        }
        
        return depth;
    }
}

```