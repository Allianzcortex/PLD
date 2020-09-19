

Recursive Solution

```Java

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(result,root);
        return result;
    }
    
    public void preorder(List<Integer> result,Node root){
        if(root==null) 
            return;
        result.add(root.val);
        for(Node node:root.children){
            preorder(result,node);
        }
        
    }
}

```

Iterative Solution :

need to push stack from right to left,so use a helper temp stack

```Java

class Solution {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        if(root==null)
            return res;
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            Stack<Node> temp = new Stack<>();
            for(Node node:cur.children)
                temp.push(node);
            while(!temp.isEmpty())
                stack.push(temp.pop());
        }
        
        return res;
    }
}

```