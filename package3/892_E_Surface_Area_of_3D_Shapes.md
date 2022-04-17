
Problem description:

```

You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).

After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.

Return the total surface area of the resulting shapes.

Note: The bottom face of each shape counts toward its surface area.

 

Example 1:


Input: grid = [[2]]
Output: 10
Example 2:


Input: grid = [[1,2],[3,4]]
Output: 34
Example 3:


Input: grid = [[1,0],[0,2]]
Output: 16
Example 4:


Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
Example 5:


Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
Output: 46
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] <= 50

```

Basic idea:

这道题时要把在坐标轴上列出的格子内部都粘起来，然后求表面积
思路时每两个格子相连，表面积就减 2。然后对每一个方格，只和上面和左边
的方格作比较，找出的最小值就是相连的部分

```Python
class Solution:
    def surfaceArea(self, grid: List[List[int]]) -> int:
        
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==0:
                    continue
                temp = 0
                n = grid[i][j]
                temp = 6*n-2*(n-1)
                
                # compare left and top
                if i>0:
                    temp-=(min(grid[i-1][j],n))*2
                
                if j>0:
                    temp-=(min(grid[i][j-1],n))*2
                
                res += temp
        return res

```