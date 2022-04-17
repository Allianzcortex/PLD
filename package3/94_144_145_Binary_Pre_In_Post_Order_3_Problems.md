Recursive method is easy to implement.
Mainly let's discuss iterative implementation.

---

PreOrder 144:

We use stack.Note that we add right first and then add left, so when poping up, the order will be left & right.

```Java
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode target = stack.pop();
            result.add(target.val);
            if(target.right!=null)
                stack.push(target.right);
            if(target.left!=null)
                stack.push(target.left);
        }
        return result;
    }
}

```

```Python
# recursive solution

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root,res)
        return res
    
    def helper(self,root,res):
        if root is None:
            return
        res.append(root.val)
        self.helper(root.left,res)
        self.helper(root.right,res)
```

```Python
# iterative solution

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack,res = [],[]
        if root is None:
            return res
        stack.append(root)
        while stack:
            root = stack.pop()
            res.append(root.val)
            if root.right is not None:
                stack.append(root.right)
            if root.left is not None:
                stack.append(root.left)
        
        return res



```

---

Inorder 94 :

The same.We use stack to add the left until reaching to the most left end.
And pop the value to get the `current` and `right` value.

```Java

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return res;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!=null) {
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        
        return res;
    }
}

```

Below is Python Solution:

```Python
# recursive 
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root,res)
        return res
    
    def helper(self,root,res):
        if root is None:
            return
        self.helper(root.left,res)
        res.append(root.val)
        self.helper(root.right,res)

```

```Python
# iterative
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res,stack=[],[]
        cur = root
        if root is None:
            return res
        
        while stack or cur:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        return res
        

```

---

PostOrder 145 :

Very like PreOrder for we use Stack. The key here is to 
add the node to the head everytime.  `add(0,elem)`

```Java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return res;
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0,cur.val);
            if(cur.left!=null)
                stack.push(cur.left);
            if(cur.right!=null)
                stack.push(cur.right);
        }
        
        return res;
        
    }
}

```

Apparently solution above may be right,but not correct way(reverse is so tricky):

Here I will provide 2 iterative Python solutions for it :

1. solution1 : use a `flag` to identify whether this node has been visited.
```Python
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res,stack = [],[(root,False)]
        while stack:
            cur,visited = stack.pop()
            if not visited:
                stack.append((cur,True))
                if cur.right:
                    stack.append((cur.right,False))
                if cur.left:
                    stack.append((cur.left,False))
            else:
                res.append(cur.val)
        
        return res

```

2. solution2 : add duplicated number , the idea is very similar with solution1,but using a 
different implementation

```Python
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res,stack = [],[root]*2
        
        while stack:
            cur = stack.pop()
            if (stack and stack[-1]==cur):
                if cur.right:
                    stack+=[cur.right]*2
                if cur.left:
                    stack+=[cur.left]*2
            else:
                res.append(cur.val)
        
        return res
```

---


Next I will add Golang Solution here:

144 PreOrder
94  InOrder

```Golang

//  revursive solution
func inorderTraversal(root *TreeNode) []int {
    var res []int
    traverse(root,&res)
    return res
}

func traverse(root *TreeNode,res *[]int) {
    if(root==nil) {
        return
    }
    traverse(root.Left,res);
    *res = append(*res,root.Val);
    traverse(root.Right,res);
}

```

```Golang

// iteration solution

func inorderTraversal(root *TreeNode) []int {
    
    res:=make([]int,0)
    stack:=make([]*TreeNode,0)
    
    for root!=nil || len(stack)>0 {
        for root!=nil {
            stack=append(stack,root)
            root = root.Left
        }
        
        root = stack[len(stack)-1]
        res = append(res,root.Val)
        root = root.Right
        stack = stack[:len(stack)-1]
    }
    
    return res
    
    
}

```
145 PostOrder