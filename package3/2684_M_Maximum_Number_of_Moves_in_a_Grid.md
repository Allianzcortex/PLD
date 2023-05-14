
Problem description:

```

You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.

 

Example 1:


Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.
Example 2:


Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.
 

Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 105
1 <= grid[i][j] <= 106

```

Basic Idea:

也就是 DFS 列出所有的情况

纯 DFS 实现的话是过不了最后一个 test Case 的，会报 TLE

```Python

class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        cnt = 0
        
        for i in range(len(grid)):
            cnt = max(cnt,self.dfs(grid,i,0))
        
        return cnt
    
    def dfs(self,grid,i,j):
        
        cnt = 0
        
        for step in [-1,0,1]:
            
            new_i,new_j = i+step,j+1
            if new_i<0 or new_i>len(grid)-1 or new_j<0 or new_j>len(grid[0])-1:
                continue
            if grid[new_i][new_j]<=grid[i][j]:
                continue
            
            temp_res=1+self.dfs(grid,new_i,new_j)
            cnt = max(cnt,temp_res)
        
        return cnt

```

需要用 memo 来做缓存，这样在遍历到 (i,j) 时如果之前已经计算过就不再重复便利

Python 解法如下：

```Python

class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        cnt = 0
        self.visited=defaultdict(int)
        
        for i in range(len(grid)):
            cnt = max(cnt,self.dfs(grid,i,0))
        
        return cnt
    
    def dfs(self,grid,i,j):
        
        cnt = 0
        
        for step in [-1,0,1]:
            
            new_i,new_j = i+step,j+1
            if new_i<0 or new_i>len(grid)-1 or new_j<0 or new_j>len(grid[0])-1:
                continue
            if grid[new_i][new_j]<=grid[i][j]:
                continue
            
            if (new_i,new_j) in self.visited:
                temp_res=1+self.visited[(new_i,new_j)]
            else:
                temp_res=1+self.dfs(grid,new_i,new_j)
                
            cnt = max(cnt,temp_res)
        
        self.visited[(i,j)] = cnt
        return cnt

```


TODO: 后续添加 BFS 以及 DP 解法