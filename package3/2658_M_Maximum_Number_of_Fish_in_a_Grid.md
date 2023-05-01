
Problem description:

```

You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

A land cell if grid[r][c] = 0, or
A water cell containing grid[r][c] fish, if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:

Catch all the fish at cell (r, c), or
Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

 

Example 1:


Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
Output: 7
Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
Output: 1
Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
0 <= grid[i][j] <= 10

```

Basic Idea:

这道题是一道典型的 DFS 解法，以 0 和边界线作为分割，要穷尽所有的 `parts`；类似的题已经很多了，
值得注意的还是 DFS 的 trick，在 `traverse()` 函数里，在开始遍历前，先把 grid[x][y] 的值存储起来
并赋值 -1，这样这个点就不会再被访问，防止陷入无限死循环。

Python 解法如下：

```Python

class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        max_res = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]>0:
                    max_res = max(max_res,self.traverse(grid,i,j))
        
        return max_res
    
    def traverse(self,grid,x,y):
        if x<0 or x>=len(grid) or y<0 or y>=len(grid[0]):
            return 0
        
        if grid[x][y]<=0:
            return 0
        
        temp_res = grid[x][y]
        grid[x][y] = -1
        for (new_x,new_y) in [(x+1,y),(x-1,y),(x,y+1),(x,y-1)]:
            temp_res += self.traverse(grid,new_x,new_y)

        return temp_res

```