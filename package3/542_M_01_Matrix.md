
Problem description:

```

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

```

---

Basic idea:

自己一开始想的是用 DFS 的解法，结果这种思路完全是错的...:

不 AC 



所以如果可以想到用 BFS 解法的话思路还是挺简单的
就很类似拓扑排序

```Python

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        queue = deque([])
        row,column = len(mat),len(mat[0])
        
        res = [[0]*column for _ in range(row)]
        
        for i in range(row):
            for j in range(column):
                if mat[i][j]==0:
                    queue.append((i,j))
        
        while queue:
            size = len(queue)
            
            for _ in range(size):
                x,y = queue.popleft()
                for (i,j) in [(0,1),(0,-1),(-1,0),(1,0)]:
                    new_x,new_y = x+i,y+j
                    if (0<=new_x<=row-1 and 0<=new_y<=column-1 and mat[new_x][new_y]==1):
                        res[new_x][new_y] = res[x][y]+1
                        mat[new_x][new_y] = 0
                        queue.append((new_x,new_y))
        
        return res

```

但自己还是想用 DFS 来实现一下：

