
Solution 1 : DFS

```Java
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null)
            return root1==root2;
        return root1.val==root2.val && (
            // case 1
        (flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right)) ||
            // case 2
            (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left))
        );
    }
    
}

```

Solution 2 : BFS

Actually there is a new test case will make the solution invalid

```
[1,3,3,4,5,6,null,null,null,7,8]
[1,3,3,null,6,4,5,null,null,null,null,8,7]
```

But still worth to share it :

```Java

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>(),q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode cur1=q1.poll(),cur2=q2.poll();
            
            if(cur1==null || cur2==null) {
                if(cur1==cur2)
                    continue;
                else
                    return false;
            }
            
            if(cur1.val!=cur2.val)
                return false;
            if(cur1.left==cur2.left || (cur1.left!=null && cur2.left!=null && cur1.left.val==cur2.left.val)) {
                q1.addAll(Arrays.asList(cur1.left,cur1.right));
            } else {
                q1.addAll(Arrays.asList(cur1.right,cur1.left));
            }
            
            q2.addAll(Arrays.asList(cur2.left,cur2.right));
        }
        
        return q1.isEmpty() && q2.isEmpty();
    }
}

```