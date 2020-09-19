
Recursive Solution :

method 1 :

```Java
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        return traverse(root,root.val);
    }
    
    public boolean traverse(TreeNode root,int target) {
        if(root==null)
            return true;
        if(root.val!=target)
            return false;
        
        return traverse(root.left,target) && traverse(root.right,target);
        
    }
}


```

method 2 : compare tree directly

```Java

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        if(root.left!=null && root.val!=root.left.val)
            return false;
        if(root.right!=null && root.val!=root.right.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}

```


Iterative Solution

```Java

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int target = root.val;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if(cur.val!=target)
                    return false;
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
        }
        
        return true;
    }
}

```