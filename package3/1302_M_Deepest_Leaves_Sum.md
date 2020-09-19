
This still doesnot fit into the medium difficulty......

simple & straight-forward

Java Solution

```Java

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return 0;
        int sum = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            sum = 0;
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                sum+=cur.val;
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
        }
        
        return sum;
    }
}

```

TODO : Add Java Recursive & Python Solution