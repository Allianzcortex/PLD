
Java Solution :

Recursive Solution :

```Java

class Solution {
    public int maxDepth(Node root) {
         if(root==null)
            return 0;
        int res = 0;
        for(Node node:root.children) {
            res= Math.max(res,maxDepth(node));
        }
        
        return 1+res;
    }
}

```


Iterative Solution :

```Java
class Solution {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node cur = queue.poll();
                for(Node node:cur.children)
                    queue.offer(node);
            }
            
            depth+=1;
        }
        
        return depth;
    }
}

```

---

Python Solution :

```Python

```