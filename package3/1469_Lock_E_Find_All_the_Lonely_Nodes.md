

```Java

In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.

Example 1:

Find All The Lonely Nodes

Input: root = [1,2,3,null,4]
Output: [4]
Explanation: Light blue node is the only lonely node.
Node 1 is the root and is not lonely.
Nodes 2 and 3 have the same parent and are not lonely.
Example 2:

Find All The Lonely Nodes

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
Output: [6,2]
Explanation: Light blue nodes are lonely nodes.
Please remember that order doesn't matter, [2,6] is also an acceptable answer.
Example 3:

Find All The Lonely Nodes

Input: root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
Output: [77,55,33,66,44,22]
Explanation: Nodes 99 and 88 share the same parent. Node 11 is the root.
All other nodes are lonely.
Example 4:

Input: root = [197]
Output: []
Example 5:

Input: root = [31,null,78,null,28]
Output: [78,28]

```

---

We can use two solutions : recursively or iteratively

1. recursive solution

```Java

class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        helper(root);        
        return ans;
    }
    
    private void helper(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right != null)
            ans.add(root.right.val);
        if(root.left != null && root.right == null)
            ans.add(root.left.val);
        
        helper(root.left);
        helper(root.right);
    }
}

```

2. iterative solution

```Java

class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null && node.right == null)
                {
                    res.add(node.left.val);
                }
                if(node.left == null && node.right != null)
                {
                    res.add(node.right.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return res;
    }
}

```