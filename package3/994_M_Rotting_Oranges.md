
Problem description:

```

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

```

Basic idea:

腐烂的橘子，这道题真是经典题...

这是很典型的 BFS 思路，纪录 fresh orange 的 count ，然后每次减 1，最后再判断是否可以完全清零：

Python 解法如下：

```Python

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        row,column = len(grid),len(grid[0])
        fresh_cnt = 0
        queue = deque([])
        
        for i in range(row):
            for j in range(column):
                if grid[i][j] == 1:
                    fresh_cnt += 1
                elif grid[i][j] == 2:
                    queue.append((i,j))
        
        minute = 0
        while queue and fresh_cnt>0:
            length = len(queue)
            
            for _ in range(length):
                x,y = queue.popleft()
                for i,j in [(0,1),(0,-1),(-1,0),(1,0)]:
                    new_x,new_y = x+i,y+j

                    if 0<=new_x<=row-1 and 0<=new_y<=column-1 and grid[new_x][new_y]==1:
                        fresh_cnt -= 1
                        grid[new_x][new_y] = 2
                        queue.append((new_x,new_y))
            
            minute += 1
        
        return minute if fresh_cnt==0 else -1

```