
This is the straight-forward solution.

We use BST to get the sorted array.

```Java
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root!=null || !s.isEmpty()) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();
        
        int left=0,right = arr.length-1;
        while(left<right) {
            int sum = arr[left] + arr[right];
            if(sum==k) {
                return true;
            } else if(sum<k) {
                left+=1;
            } else {
                right-=1;
            }
        }
        
        return false;
    }
}

```

Solution 2 :

A better(Best) way : use two iterators.

```Java

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
       
        for(TreeNode cur=root;cur!=null;cur=cur.left) {
            lStack.push(cur);
        }
        
        for(TreeNode cur=root;cur!=null;cur=cur.right) {
            rStack.push(cur);
        }
        
        while(!lStack.isEmpty() && !rStack.isEmpty() && lStack.peek()!=rStack.peek()) {
            int temp = lStack.peek().val + rStack.peek().val;
            if(temp==k)
                return true;
            else if(temp<k) {
                // get a bigger one,start from lStack
                for(TreeNode cur = lStack.pop().right;cur!=null;cur=cur.left)
                    lStack.push(cur);
            } else {
                // get a smaller one,start from rStack
                for(TreeNode cur = rStack.pop().left;cur!=null;cur=cur.right)
                    rStack.push(cur);
            }
        }
        
        return false;
       
    }
}

```

---

Solution 3 :

Another solution is to use HashSet.

```Java
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return dfs(root,s,k);
    }
    
    public boolean dfs(TreeNode root,Set<Integer> s,int target) {
        if(root==null)
            return false;
        if(s.contains(target-root.val))
            return true;
        s.add(root.val);
        return dfs(root.left,s,target) || dfs(root.right,s,target);
    }
}

```

---

Python Implementation Solution2:

```Python

class Solution:
    
    def buildStack(self,node,stack,isLeft):
        while node:
            stack.append(node)
            node = node.left if isLeft else node.right
    
    def findTarget(self, root: TreeNode, k: int) -> bool:
        l_stack,r_stack=[],[]
        self.buildStack(root,l_stack,True)
        self.buildStack(root,r_stack,False)
        
        while(l_stack and r_stack and l_stack[-1].val!=r_stack[-1].val):
            temp = l_stack[-1].val + r_stack[-1].val
            if(temp==k):
                return True
            elif(temp<k):
                # search from left stack,add a biger value
                node = l_stack[-1].right
                l_stack.pop()
                while node:
                    l_stack.append(node)
                    node = node.left
            else:
                # search from right stack, add a smaller value
                node = r_stack[-1].left
                r_stack.pop()
                while node:
                    r_stack.append(node)
                    node = node.right
           
        return False
                    
```