
Java Solution:

There are two types of solutions:

1. iterative. My most like one. Using two Stacks

```Java

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        while(root1!=null || root2!=null || !s1.isEmpty() || !s2.isEmpty()) {
            while(root1!=null) {
                s1.push(root1);
                root1 = root1.left;
            }
            
            while(root2!=null) {
                s2.push(root2);
                root2 = root2.left;
            }
            
            if(s1.isEmpty() && s2.isEmpty())
                break;
            if(!s1.isEmpty() && !s2.isEmpty()) {
                int val1 = s1.peek().val;
                int val2 = s2.peek().val;
                if(val1<val2) {
                    res.add(val1);
                    // s1 should be bigger
                    root1 = s1.pop().right;
                } else {
                    // s2 should be bigger
                    res.add(val2);
                    root2 = s2.pop().right;
                }
            } else if (!s1.isEmpty()) {
                res.add(s1.peek().val);
                root1 = s1.pop().right;
            } else {
                res.add(s2.peek().val);
                root2 = s2.pop().right;
            }
            
        }
        
        return res;
    }
}

```

2. Using recursive solution. Need to merge two lists together finally

```Java
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        inOrder(root1,res1);
        List<Integer> res2 = new ArrayList<>();
        inOrder(root2,res2);
        
        return mergeLists(res1,res2);
    }
    
    public void inOrder(TreeNode root,List<Integer> res) {
        if(root==null)
            return;
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
    
    public List<Integer> mergeLists(List<Integer> res1,List<Integer> res2) {
        List<Integer> res = new ArrayList<>();
        int i=0,j=0;
        while(i<res1.size() && j<res2.size()) {
            if(res1.get(i)<res2.get(j))
                res.add(res1.get(i++));
            else
                res.add(res2.get(j++));
        }
        
        while(i<res1.size())
            res.add(res1.get(i++));
        while(j<res2.size())
            res.add(res2.get(j++));
        
        return res;
    }
}


```