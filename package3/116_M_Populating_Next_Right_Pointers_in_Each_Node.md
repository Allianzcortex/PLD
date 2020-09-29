
Java : Iterative Solution

```Java

class Solution {
    public Node connect(Node root) {
      
        if(root==null)
            return root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        

        while(!queue.isEmpty()) {
            int size = queue.size();
            // sure we can also set a prev variable and use classic prev!=null 
            // condition to judge
            for(int i=0;i<size;i++) {
            Node cur = queue.poll();
             if(cur.left!=null)
                queue.offer(cur.left);
            if(cur.right!=null)
                queue.offer(cur.right);
            if(i==size-1) 
                cur.next = null;
            else
                cur.next = queue.peek();
            }
        }
        
        return root;
    }
}

```
DFS solution

```java

class Solution {
    public Node connect(Node root) {
        traverse(root,null);
        return root;
    }
    
    public void traverse(Node pre,Node next) {
        if(pre==null)
            return;
        pre.next = next;
        traverse(pre.left,pre.right);
        traverse(pre.right,pre.next==null?null:pre.next.left);
    }
}

```