
There are two islands :

So first we use DFS to fill the color, the 1st island is from 1->2.
Then 2nd we use BFS to find the path, to see the least steps we need to reach another island

```Java

class Solution {
    int minSteps = Integer.MAX_VALUE;
    public int shortestBridge(int[][] A) {
        // 1 1 1 1 1
        // 1 0 0 0 1
        // 1 0 1 0 1
        // 1 0 0 0 1
        // 1 1 1 1 1
        if(A==null || A.length==0)
            return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++) {
               if(A[i][j]==1 && !found) {
                   fillColor(A,i,j);
                   found = true;
               }
                if(found && A[i][j]==1) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        int step = 0;
        int[][] direc = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(queue.size()!=0) {
            int size = queue.size();
            for(int j=0;j<size;j++) {
                int[] cur = queue.poll();
                for(int i=0;i<4;i++) {
                    int x=cur[0]+direc[i][0];
                    int y=cur[1]+direc[i][1];
                    
                    if(x<0 || x>=A.length || y<0 || y>=A.length)
                        continue;
                    // we can use a boolean[][] visited to optimize the time complexity later
                    if(A[x][y]==1)
                        continue;
                    if(A[x][y]==2)
                        return step;
                    if(A[x][y]==0) {
                        A[x][y]=1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            step+=1;
        }
        
        return -1;
    }
    
    public void fillColor(int[][] A,int i,int j) {
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || A[i][j]!=1)
            return;
        
        A[i][j]=2;
        fillColor(A,i-1,j);
        fillColor(A,i+1,j);
        fillColor(A,i,j-1);
        fillColor(A,i,j+1);
    }
}

```