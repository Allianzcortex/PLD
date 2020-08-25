
Recursive solution

```Java

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        int sum = 0;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

```

Another idea is to set up a new method will add a new parameter `dir` like `public void solve(TreeNode root,boolean isLeft)`
And change this value when call the left/right node recursively.

Iterative Solution

```Java


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur==null)
                    continue;
                if(cur.left!=null && cur.left.left==null && cur.left.right==null)
                    sum += cur.left.val;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        
        return sum;
    }
}

```