
Problem description:

```

There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

Constraints:

n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].

```

---

Basic idea:

这就是赤裸的不能再赤裸的 `topological sort` 题目，所谓的 `terminal node`
就是入度为 0 的点。所以具体解题思路如下：

1. 初始化纪录所有节点的入度和出度。对出度，只用记录数量；对入度，要纪录是从哪个节点
开始指向自己

2. 然后用一个 queue 存储所有的 `terminal node`，之后依次遍历，找到 terminal node 对应的
所有入度节点，该节点出度减一。如果该节点出度为 0，那么再把该节点加入到 `queue` 中：

Python 代码如下：

```Python

class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        outdegree = defaultdict(lambda:0)
        indegree = defaultdict(list)
        queue = deque([])
        
        # initialize indegree/outdegree array
        for i,nodes in enumerate(graph):
            outdegree[i] = len(nodes)
            if outdegree[i]==0:
                queue.append(i)
            
            for j in nodes:
                indegree[j].append(i)
        
        res = []
        while queue:
            term_node = queue.popleft()
            res.append(term_node)
            
            for node in indegree[term_node]:
                outdegree[node] -= 1
                
                if outdegree[node]==0:
                    queue.append(node)
        
        return sorted(res)

```