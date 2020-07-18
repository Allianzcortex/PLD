```Java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix ==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int i=0,j=matrix[0].length-1;
        while(i>=0 && i<=matrix.length-1 && j>=0 && j<=matrix[0].length-1) {
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target) {
                j-=1;
            } else {
                i+=1;
            }
        }

        return false;
    }
}

```