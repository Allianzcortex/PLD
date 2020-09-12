
BFS : pretty simple. one-round bug free

```Java

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            double tempRes = 0.0;
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                tempRes += cur.val;
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            res.add(tempRes/size);
        }

        return res;
    }
}

```