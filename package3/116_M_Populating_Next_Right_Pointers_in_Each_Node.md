
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

---

Python Solution :

Iterative one:

```Python

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        if not root:
            return root 
        
        queue = deque([root])
        
        while queue:
            size = len(queue)
            for index in range(size):
                cur = queue.popleft()
                if cur.left is not None:
                    queue.append(cur.left)
                if cur.right is not None:
                    queue.append(cur.right)
                    
                cur.next = queue[0] if index<size-1 else None

        return root

```

And recursive solution :

```Python

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        if not root or not root.left:
            return root 
        
        root.left.next = root.right
        
        if root.next is not None:
            root.right.next = root.next.left
        
        self.connect(root.left)
        self.connect(root.right)
        
        return root

```