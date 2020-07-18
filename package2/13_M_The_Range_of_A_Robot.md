
This is DFS Solution:

```Java
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited,m,n,k,0,0);
    }

    public int dfs(boolean[][] visited,int m,int n,int k,int i,int j) {
        if(i<0 || i>=m || j<0 || j>=n || getSum(i)+getSum(j)>k || visited[i][j])
            return 0;
        visited[i][j]=true;
        return 1+dfs(visited,m,n,k,i,j+1)+dfs(visited,m,n,k,i+1,j);
    }

    public int getSum(int n) {
        if(n<10)
            return n;
        return n/10+getSum(n%10);
    }
}

```

Check more for BFS solutions