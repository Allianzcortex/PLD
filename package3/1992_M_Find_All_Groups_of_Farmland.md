
Problem description:

```
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

 

Example 1:


Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
Example 2:


Input: land = [[1,1],[1,1]]
Output: [[0,0,1,1]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].
Example 3:


Input: land = [[0]]
Output: []
Explanation:
There are no groups of farmland.

```

Basic idea :

这道题一开始看起来很像油井问题，所以自己思维就陷入到里面，
有一柄锤子就觉得哪里都是刀子 (:-

下面的解法是自己第一次做的，也 AC 了，想法就是依次遍历，给所有为 1 的区域
进行染色，然后把位置记录下来，排序，找出最小和最大，真是太麻烦了

虽然不是最优解但也 AC 了

```Python

class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        index = 2
        
        row,column = len(land),len(land[0])
        res = []
        
        for i in range(row):
            for j in range(column):
                if land[i][j] == 1:
                    self.dfs(land,i,j,res,index)
                    index += 1
        
        output = []

        for array in res:
            array.sort(key=lambda x:(x[0],x[1]))

            output.append([array[0][0],array[0][1],array[-1][0],array[-1][-1]])

        
        return output
    
    
    def dfs(self,land,i,j,res,index):
        if i<0 or i>=len(land) or j<0 or j>=len(land[0]) or land[i][j]!=1:
            return
        
        land[i][j] = index
        if len(res)==index-2:
            res.append([])
        
        res[index-2].append((i,j))
        for x,y in [(0,1),(0,-1),(1,0),(-1,0)]:
            self.dfs(land,i+x,j+y,res,index)

```

---

正确的想法是这样，每个 farmland 都是一个矩形，因为是从上往下从左到右遍历，所以
遇到的第一个为 "1" 的点一定是最左上的点，要从这个点出发找出最右下的点。

```Python

class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        index = 2
        
        row,column = len(land),len(land[0])
        res = []
        
        for i in range(row):
            for j in range(column):
                if land[i][j] == 0:
                    continue

                a,b = i,j

                while b<column and land[a][b]==1:
                    b+=1
                b-=1

                while a<row and land[a][b]==1:
                    a+=1
                a-=1

                for x in range(i,a+1):
                    for y in range(j,b+1):
                        land[x][y] = 0

                res.append([i,j,a,b])
            
        return res

```

当然这个找的过程也可以用 dfs 来做，返回的就是 min(x1,x2) 和 max(y1,y2)