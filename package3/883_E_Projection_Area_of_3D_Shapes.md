
Problem description:

```

You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).

We view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.

 

Example 1:


Input: grid = [[1,2],[3,4]]
Output: 17
Explanation: Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
Example 2:

Input: grid = [[2]]
Output: 5
Example 3:

Input: grid = [[1,0],[0,2]]
Output: 8
Example 4:

Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 14
Example 5:

Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
Output: 21
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] <= 50

```

Basic idea:

求投影的面积，one-pass 求出每个 row,column 最大长度就可以

Python 解法如下：

```Python

class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        
        row,column = len(grid),len(grid[0])
        
        area1 = 0
        
        maxRow = [0]*row
        maxColumn = [0]*column
        
        for i in range(row):
            for j in range(column):
                maxRow[i] = max(maxRow[i],grid[i][j])
                maxColumn[j] = max(maxColumn[j],grid[i][j])
                
                if grid[i][j]!=0:
                    area1 += 1
        
        area2 = sum(maxRow)
        area3 = sum(maxColumn)
        
        return area1+area2+area3

```

为了节省空间，可以不用一整个 array 存储最大值，而是访问 grid[i][j]
来决定 maxRow，访问 grid[j][i] 来决定 maxColumn，因为根据题意 
grid.length = grid[i].length = n

对应解法如下：

```Python

class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        
        row,column = len(grid),len(grid[0])
        
        res = 0
        
        for i in range(row):
            maxRow = 0
            maxColumn = 0
            for j in range(column):
                maxRow = max(maxRow,grid[i][j])
                maxColumn = max(maxColumn,grid[j][i])
                
                if grid[i][j]!=0:
                    res += 1
            res += (maxRow+maxColumn)
        
        return res

```