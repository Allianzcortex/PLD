

Apparently the following is not a valid answer which will enter into a dead circle.

```Java

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Node copy = new Node(node.val);
        List<Node> copyNeighbors = new ArrayList<>();
        for(Node n:node.neighbors) {
            copyNeighbors.add(cloneGraph(n));
        }
        copy.neighbors = copyNeighbors;
        System.out.println(copy.val);
        return copy;
    }
}

```

While a proper solution is to use a HashMap to store clone nodes

```Java

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer,Node> map = new HashMap<>();
        
        return clone(node,map);
    }
    
    public Node clone(Node node,Map<Integer,Node> map) {
        if(node==null)
            return null;
        if(map.containsKey(node.val))
            return map.get(node.val);
        
        Node copy = new Node(node.val);
        map.put(node.val,copy);
        for(Node no:node.neighbors) {
            copy.neighbors.add(clone(no,map));
        }
        
        return copy;
    }
}

```