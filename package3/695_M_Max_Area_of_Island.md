Problem Description:

```
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]

Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.

```

![pic](pic/maxarea1-grid.jpg)


---

Solution : standard DFS way

Python Solution:

```Python
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        # 1 means isload , 0 means ocean
        # DFS / BFS to traverse through the whole area
        # count the part : requires 2 points:
        # a. must be 1
        # b. msut be connected with each other vertically / horizontally
        
        res = 0
        if len(grid)==0 or len(grid[0]) == 0:
            return res
        
        row , column = len(grid),len(grid[0])
        index = 2
        
        def traverse(grid,i,j,index):
            if i<0 or i>=row or j<0 or j>=column:
                return 0
            if grid[i][j]==index or grid[i][j]==0:
                return 0
            grid[i][j] = index
            res = 1 + traverse(grid,i-1,j,index) + traverse(grid,i+1,j,index) \
                    + traverse(grid,i,j-1,index) + traverse(grid,i,j+1,index)
            return res
        
        for i in range(row):
            for j in range(column):
                if grid[i][j] == 1:
                    cnt = traverse(grid,i,j,index)
                    index += 1
                    print(cnt)
                    res = max(res,cnt)
        
        return res

```

Golang Solution :

```Go

var direc = [][]int{{0,1},{0,-1},{-1,0},{1,0}}

func maxAreaOfIsland(grid [][]int) int {
    res := 0
    if len(grid)==0 || len(grid[0])==0 {
        return res
    }
    
    row,column := len(grid),len(grid[0])
    index := 2
    for i:=0;i<row;i++ {
        for j:=0;j<column;j++ {
            if grid[i][j]==1 {
                if cnt := traverse(grid,i,j,row,column,index);cnt>res {
                    res = cnt
                }
                index++
            }
        }
    }
    
    return res
}


func traverse(grid [][]int,i,j,row,column,index int) int {
    if i<0 || i>=row || j<0 || j>=column {
        return 0
    }
    
    if grid[i][j]==0 || grid[i][j]==index {
        return 0
    }

    grid[i][j] = index
    res := 1
        for k:=0;k<len(direc);k++ {
            res = res + traverse(grid,i+direc[k][0],j+direc[k][1],row,column,index)
        }
    
    return res
}

```