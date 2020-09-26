
Pretty difficult to understand......

```Java

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        if(mat==null || mat.length==0 || mat[0].length==0)
            return new int[][]{};
        
        int row = mat.length,column = mat[0].length;
        int[][] rangeSum = new int[row+1][column+1];
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                rangeSum[i+1][j+1]=rangeSum[i+1][j]+rangeSum[i][j+1]-rangeSum[i][j]+mat[i][j];
            }
        }

        int[][] res = new int[row][column];
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                 
                int r1 = Math.max(0,i-K),r2=Math.min(row,i+K+1);
                int c1 = Math.max(0,j-K),c2=Math.min(column,j+K+1);
                
                res[i][j]=rangeSum[r2][c2]-rangeSum[r2][c1]-rangeSum[r1][c2]+rangeSum[r1][c1];
            }
        }
        
        return res;
    }
}

```