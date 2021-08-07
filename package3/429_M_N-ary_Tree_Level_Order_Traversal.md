
Problem description:

```
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

```

Idea :

还是用 queue 的 bfs，以后有机会再看 DFS 的解法好了

就是用 queue 来依次读取节点的 children

Python 解法如下：

```Python

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        
        res = []
        if not root:
            return res
        
        queue = deque([root])
        level = 0
        
        while queue:
            size = len(queue)
            if level == len(res):
                res.append([])
                
            for _ in range(size):
                cur = queue.popleft()
                res[level].append(cur.val)
                
                for child in cur.children:
                    queue.append(child)
            
            level += 1
        
        return res

```

straight-forward solution

```Java

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node cur = queue.poll();
                temp.add(cur.val);
                for(Node node:cur.children) {
                    queue.add(node);
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}


```