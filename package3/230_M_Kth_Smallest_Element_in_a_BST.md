
Problem description:

```

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST’s total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

```



There are 2 solutions :

In-order : `left middle right` will order the value from small to big

1. Iterate through the BST(with Stack)
This is the solution I use


```Java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // left middle right
        Stack<TreeNode> s = new Stack<>();
        int index = 0;
        while(!s.isEmpty() || root!=null) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            index+=1;
            if(index==k)
                return root.val;
            else {
                root = root.right;
            }
        }
        
        return -1;
    }
}

```

2. DFS iterate through the BST(recursively)

It will require us to use global variables

```Java
class Solution {
    private int counter = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
         solve(root,k);
         return res;
    }
    
    public void solve(TreeNode root,int k) {
        if(root.left!=null)
            solve(root.left,k);
        counter+=1;
        if(counter==k) {
            res = root.val;
            return;
        }
        if(root.right!=null)
            solve(root.right,k);
        
    }
}

```

---

Python Solution

