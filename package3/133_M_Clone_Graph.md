
Problem description:

```
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

 

Example 1:


Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
Example 2:


Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.
Example 4:


Input: adjList = [[2],[1]]
Output: [[2],[1]]
 

Constraints:

The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.

```

Basic idea:

这道题是要对 `graph` 进行深度拷贝

自己一开始的思路如下，但发现很容易陷入死循环：

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

所以用一个 HashMap 来存储所有要被拷贝的节点：

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

---

对应的 Python 解法如下：

首先是 BFS 思路，也是用 `{}` 来存储原始节点和 copy 节点的对应关系：

```Python

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if not node:
            return None
        
        matches = {}
        copyNode = Node(node.val,[])
        matches[node] = copyNode
        
        queue = deque([node])
        
        while queue:
            curr = queue.popleft()
            for neighbor in curr.neighbors:
                
                if neighbor not in matches:
                    copyNeighbor = Node(neighbor.val,[])
                    matches[neighbor] = copyNeighbor
                    queue.append(neighbor)
                    matches[curr].neighbors.append(copyNeighbor)
                
                else:
                    matches[curr].neighbors.append(matches[neighbor])
        
        return copyNode

```

其次是 `DFS` 思路：

```Python

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        return self._clone(node,{})
    
    def _clone(self, node,matches):
        
        if not node:
            return None
        
        if node in matches:
            return matches[node]
        
        copyNode = Node(node.val,[])
        matches[node] = copyNode

        for neighbor in node.neighbors:
            copyNode.neighbors.append(self._clone(neighbor,matches))
        
        return copyNode

```