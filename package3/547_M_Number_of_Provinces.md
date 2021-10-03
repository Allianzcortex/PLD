
Problem description:

```

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

```

Basic idea: 这道题有好几种解法

第一种是最经典的，也就是 DFS:

用一个数组 visited[] 来表示是否已经访问过，以此阻止重复
每发现一个 `isConnected[i][j]==1`，就 DFS 重复访问，把对应的
visited[j] 标记为 True

对应的 Python 代码如下：

```Python

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        row = len(isConnected)
        visited = [False]*row
        count = 0
        
        for i in range(row):
            if not visited[i]:
                self.dfs(isConnected,visited,i)
                count += 1
        
        return count
    
    def dfs(self,isConnected,visited,i):
        
        for j in range(len(isConnected)):
            if not visited[j] and isConnected[i][j]==1:
                visited[j] = True
                self.dfs(isConnected,visited,j)

```

---

第二种解法是 union find :

## TODO 
add it later