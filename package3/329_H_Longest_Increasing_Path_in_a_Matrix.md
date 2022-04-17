
Problem description:

```
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

```

---

Basic idea:

这道题是自己在面 `textiq` 遇到的原题，用 `dfs+map` 解决：
现在发现当时 `TLE` 的 case 好像是因为自己用了 `>` 而不是 `>=`，题目要求
严格递增。

Python 解法如下：

```Python

class Solution:
    def longestIncreasingPath(self, area: List[List[int]]) -> int:
        
        if not area:
            return 0

        row,column = len(area),len(area[0])

        maps = dict()

        for i in range(row):
            for j in range(column):
                self.traverse(area,i,j,1,maps)

        return max(maps.values())


    def traverse(self,area,x,y,length,maps):

        key = (x,y)
        if key in maps:
            return maps[key]

        curr_length = 1
        for i,j in [(0,1),(0,-1),(1,0),(-1,0)]:
            new_x,new_y = x+i,y+j
            if new_x<0 or new_x>len(area)-1 or new_y<0 or new_y>len(area[0])-1:
                continue
            if area[x][y] <= area[new_x][new_y]:
                continue    
            curr_length = max(curr_length,1+self.traverse(area,new_x,new_y,length,maps))

        maps[key] = curr_length
        return length + curr_length - 1

```