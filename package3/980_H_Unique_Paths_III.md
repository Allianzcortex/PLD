
Problem description:

```

You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.

```

Basic idea:

这道题虽然标记是 hard，但实际也就是 medium 的难度
要保证可以走完所有空的 cell，那么就计算空的 cnt 数量，然后当走到 `2` 的时候看 cnt
如果为空，就意味着已经走完所有的空节点；如果不为空，就说明此路不通，也要返回。

好，自己第二次做的解法和自己一开始的解法完全一致耶 ！

Python 解法如下：

```Python

class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        visited = set()
        row,column = len(grid),len(grid[0])
        cnt = 0
        start_x,start_y = -1,-1
        
        for i in range(row):
            for j in range(column):
                if grid[i][j]==0:
                    cnt += 1
                elif grid[i][j]==1:
                    cnt += 1
                    start_x,start_y = i,j
        
        res = []
        self.dfs(grid,start_x,start_y,visited,cnt,[],res)
        
        return len(res)
    
    def dfs(self,grid,i,j,visited,cnt,path,res):

        if i<0 or i>len(grid)-1 or j<0 or j>len(grid[0])-1:
            return
        if (i,j) in visited or grid[i][j]==-1:
            return
        if grid[i][j]==2:
            if cnt==0:
                res.append(path[:])
            return

        visited.add((i,j))
        path.append((i,j))
        for x,y in [(0,1),(0,-1),(1,0),(-1,0)]:
            new_x,new_y = i+x,y+j
            self.dfs(grid,new_x,new_y,visited,cnt-1,path,res)

        path.remove((i,j))
        visited.remove((i,j))

```

The basic idea is right,use DFS,but it can be optimized in many
small aspects.

For example, we donot need to use a boolean[][] arry to check whether
this square is used,just set it to -2 and change the condition into
if(grid[x][y]<0). 

And also it will be better if we can remove global variables.

```Java

class Solution {
    
    int cnt = 0;
    public int uniquePathsIII(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int row=grid.length,column=grid[0].length;
        
        boolean[][] used = new boolean[row][column];
        int emptyCount = 1;
        int startX=-1,startY=-1;
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(grid[i][j]==1) {
                    startX = i;
                    startY = j;
                }
                if(grid[i][j]==0)
                    emptyCount += 1;
            }
        }
        traverse(grid,startX,startY,emptyCount,used);
        return cnt;
    }
    
    public void traverse(int[][] grid,int endX,int endY,int emptyCount,boolean[][] used) {
        if(endX<0 || endX>=grid.length || endY<0 || endY>=grid[0].length || used[endX][endY] || grid[endX][endY]==-1)
            return;

        if(grid[endX][endY]==2) {
            if(emptyCount==0)
                cnt+=1;
            return;
        }
        
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        emptyCount -= 1;
        used[endX][endY]=true;
        for(int i=0;i<4;i++) {
            traverse(grid,endX+dir[i][0],endY+dir[i][1],emptyCount,used);
        }
        
        emptyCount += 1;
        used[endX][endY]=false;
    }
}

```
