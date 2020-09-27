

```Java

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map = new HashMap<Node,Node>();
        
        // loop 1 store all nodes
        Node node = head;
        while(node!=null){
            map.put(node,new Node(node.val,node.next,node.random));
            node = node.next;
        }
        
        // loop2 build new relationship
        node = head;
        while(node!=null){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
            node=node.next;
        }
        
        return map.get(head);
        
    }
}

```

TODO : check discussions & add other solutions / Python