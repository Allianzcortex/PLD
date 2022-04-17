
Problem Description:

```
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

```

Solution :

只要能用一个东西把 0/1 区分开来就行

Python Solution :


```Python

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or not grid[0]:
            return 0
        
        row,column = len(grid),len(grid[0])
        cnt = 2
        
        for i in range(row):
            for j in range(column):
                if grid[i][j] == '1':
                    self.dfs(grid,i,j,str(cnt))
                    cnt += 1
        
        return cnt-2
    
    def dfs(self,grid,i,j,cnt):
        if i<0 or i>len(grid)-1 or j<0 or j>(len(grid[0])-1):
            return
        if grid[i][j] !='1':
            return
        
        grid[i][j] = cnt
        
        for x,y in [(1,0),(-1,0),(0,1),(0,-1)]:
            self.dfs(grid,i+x,j+y,cnt)


```

---

Java Solution :

```Java

class Solution {
    public int numIslands(char[][] grid) {
         int start = 2;
        if(grid == null || grid.length==0)
            return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1'){
                    // traverse and put all surrounded into index
                    int x=i,y=j;
                    traverse(grid,i,j,(char)(start+'0'));
                    start+=1;
                }
            }
        }  

        return start-2;
    }
    
    public void traverse(char[][] grid,int i,int j,char newChar) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1')
            return;
        grid[i][j] = newChar;

        traverse(grid,i+1,j,newChar);
        traverse(grid,i-1,j,newChar);
        traverse(grid,i,j+1,newChar);
        traverse(grid,i,j-1,newChar);
    }
}

```