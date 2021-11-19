
Problem description:

```

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000

```

Basic idea:

简而言之，这道题如果不看解法真的做不出来...
因为

这道题的思路是 DFS+BFS 的结合：

1. DFS:DFS 遍历得到所有 parent 和 children 的对应关系，以例子中的图为例，我们应该可以得到：

```
cache[3]=[1,5];

cache[5]=[3,6,2]; // 其中 3 是 5 的 parent，6 和 2 是 5 的 children，我们要把所有的关系都加入到列表中

```

2. BFS:BFS 从 target 开始，迭代 K 次，迭代 K 次以后得到的所有 Node 结果，无论是 parent 和 children，就
是我们所想要的结果


Python 解法如下：

```Python

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        
        cache = defaultdict(list)
        self.build_cache(root,None,cache)
        
        res = self.get_k_nodes(root,target,k,cache)
        return [node.val for node in res]
    
    
    def build_cache(self,child,parent,cache):
        """
        cache[parent] = [list of parent.children]
        cache[children] = [list of children.parent]
        """
        
        if not child:
            return
        if child and parent:
            cache[parent].append(child)
            cache[child].append(parent)
        
        self.build_cache(child.left,child,cache)
        self.build_cache(child.right,child,cache)
    
    def get_k_nodes(self,root,target,k,cache):
        """
        use bfs to iterate through the target k times
        find all parent w/ children
        """
        queue = deque([target])
        visited = set()
        visited.add(target)
        res = [target]

        for i in range(k):
            size = len(queue)
            temp = []
            for _ in range(size):
                curr = queue.popleft()
                for node in cache[curr]:
                    if node not in visited:
                        visited.add(node)
                        temp.append(node)
            queue = deque(temp)
            if i==k-1:
                res = temp[:]
        return res

```

---

Java 解法如下:

虽然思路是一样的，但显然写起来复杂了些，并且因为 Java 没有类似 Python 那样的 defaultdict，所以如果遇到如下的 testcase:

```
[1]
1
0
```

因为只有一个元素，所以它不存在 parent/child，于是它就不会被加入到 hashmap 中(python 中哪怕它不存在，对应的 value 也是 [])
于是在 `for (TreeNode curr:map.get(curr))` 语句中就会报 keyError

解决方法是提前判断并添加对应语句：

```java
if(!map.containsKey(target)) {
            return res;
        }
```

对于 `k==0` 这种情况也要小心，在 Python 环境下自己用 `i==k-1` 来判断是否循环到最重点，所以必须要一开始就设置 `res=[target]`
而在 Java 环境下自己用 `k==0` 来判断，一开始就可以把 res 设置为空。

```Java

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        // step1 : build relationship between parent/children
        Map<TreeNode,List<TreeNode>> map = new HashMap<>();
        dfs(map,root,null);
        
        // step2 : use BFS to iterate k times 
        List<Integer> res = bfs(map,target,k);
        return res;
    }
    
    private List<Integer> bfs(Map<TreeNode,List<TreeNode>> map,TreeNode target,int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        List<Integer> res = new ArrayList<>();
        
        if(!map.containsKey(target)) {
            return res;
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            if(k==0) {
            for(int j=0;j<size;j++) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            for(int j=0;j<size;j++) {
                TreeNode curr = queue.poll();
                for(TreeNode node : map.get(curr)) {
                    if(visited.contains(node)) continue;
                    visited.add(node);
                    queue.add(node);
                }
            }
            
            k-=1;
        }
        
        return res;
    }
    
    
    private void dfs(Map<TreeNode,List<TreeNode>> map,TreeNode child,TreeNode parent) {
        if(child==null) {
            return;
        }
        if(child!=null && parent!=null) {
            if(!map.containsKey(child)) {
                map.put(child,new ArrayList<TreeNode>());
            }
            
            if(!map.containsKey(parent)) {
                map.put(parent,new ArrayList<TreeNode>());
            }
            
            map.get(child).add(parent);
            map.get(parent).add(child);
            
        }
        
        dfs(map,child.left,child);
        dfs(map,child.right,child);
    }
}


```