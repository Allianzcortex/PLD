
The same idea as 54 Spiral Matrix I

```Java

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int index = 1;
        
        int minRow=0,maxRow=n-1;
        int minColumn=0,maxColumn=n-1;
        
        while(true) {
            // from left to right
            for(int j=minColumn;j<=maxColumn;j++) {
                matrix[minRow][j] = index++;
            }
            
            if(++minRow>maxRow)
                break;
            
            // from top to down
            for(int i=minRow;i<=maxRow;i++) {
                matrix[i][maxColumn] = index++;
            }
            if(--maxColumn<minColumn)
                break;
            
            // from right to left
            for(int j=maxColumn;j>=minColumn;j--) {
                matrix[maxRow][j] = index++;
            }
            
            if(--maxRow<minRow)
                break;
            
            // from down to top
            for(int i=maxRow;i>=minRow;i--) {
                matrix[i][minColumn] = index++;
            }
            
            if(++minColumn>maxColumn)
                break;
        }
        
        return matrix;
    }
}

```

TODO add python solution later