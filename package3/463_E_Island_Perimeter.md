
Problem description:

```

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.

```

Basic idea:

这道题就是数学问题：

a) 每在岛屿里多加一个岛，那么周长加 4
b) 每发现有两个岛相邻，那么周长 -2(注意不是 -1，两个岛相连等同于
这条边消失)

自己的 Python 解法如下：

```Python

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        
        res = 0
        visited = set()
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==0:
                    continue
                
                res+=4
                visited.add((i,j))
                
                for x,y in [(0,1),(0,-1),(-1,0),(1,0)]:
                    new_x,new_y = i+x,j+y
                    
                    if (new_x,new_y) in visited:
                        res-=2
        
        return res

```

---

然后进行优化一下，先计算数量再最后计算周长：

```Python

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        
        islandCnt = 0
        neighborCnt = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==0:
                    continue
                
                islandCnt += 1
                
                # up-down neighbour
                if i+1<len(grid) and grid[i+1][j]==1:
                    neighborCnt += 1
                
                # left-right neighbour
                if j+1<len(grid[0]) and grid[i][j+1]==1:
                    neighborCnt += 1
        
        return islandCnt*4-neighborCnt*2


```