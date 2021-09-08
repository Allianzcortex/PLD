
Problem description:

```

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
 

Follow-up:

You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

```

Basic idea :

解法如下

```Java

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int length=queue.size();
            Node pre = null;
            for(int i=0;i<length;i++) {
                Node current = queue.poll();
                if(pre!=null) {
                    pre.next = current;
                }
                    pre = current;
                
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }
        }
        
        return root;
        
    }
}

```