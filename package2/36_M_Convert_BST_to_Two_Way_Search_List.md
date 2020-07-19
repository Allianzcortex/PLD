
The overall order is like in-order 

So we have two ways to solve it :

Solution1: recursive dfs.And we must use global variables

```Java


class Solution {
    Node pre=null,head=null,tail=null;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return root;
        solve(root);
        head.left =tail;
        tail.right=head;
        return head;
    }

    public void solve(Node root) {
        if(root==null)
            return ;
        solve(root.left);
        root.left = pre;
        if(pre==null) {
            head = root;
        } else {
            pre.right = root;
        }
        pre = root;
        tail = root;
        solve(root.right);
    }
}


```

---

Solution2 : Use stack to mock the in-order

```Java

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return root;
        Node head=null;
        Node pre=null,tail=null;
        Node current = root;

        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || current!=null) {
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            tail = current;
            if(pre==null) {
                // this will be the head we need
                head = current;
                
            } else {
                pre.right = current;
                current.left = pre;
            }

            pre = current;
            current = current.right;
        }

        head.left=tail;
        tail.right=head;
        return head;

    }
}


```