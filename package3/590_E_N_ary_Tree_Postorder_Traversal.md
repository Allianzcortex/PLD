

This is the definition of N-ary tree

```Java

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

```


The 1st Solution : Recursive : like binary tree

```Java

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        traverse(root,res);
        
        return res;
    }
    
    public void traverse(Node root,List<Integer> res) {
        if(root==null)
            return;
        for(Node node:root.children)
            traverse(node,res);
        res.add(root.val);
    }
}

```

The 2nd Soluiton : Iterative : 

Like Problem 145 : push from left to right and add 0 in res

```Java

class Solution {
    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        if(root==null)
            return res;
        stack.push(root);
        
        while(!stack.empty()) {
            Node cur = stack.pop();
            res.add(0,cur.val);
            for(Node node:cur.children)
                stack.push(node);
        }
        
        return res;
    }
}


```
