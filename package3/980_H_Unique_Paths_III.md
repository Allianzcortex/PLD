
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

TODO : check explanations && add more solutions