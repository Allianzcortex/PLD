
Classic problem in CC150.

Iterate from 4 directions,and break when its over the bound.

```Java

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int minRow=0,maxRow=matrix.length-1,minColumn=0,maxColumn=matrix[0].length-1;
        
        int index = 0;
        int i,j;
        while(true) {
            // left to right
            for(i = minRow,j=minColumn;j<=maxColumn;j++) {
                res.add(matrix[i][j]);
            }
            if(++minRow>maxRow)
                break;
            
            // from top to down
            for(j=maxColumn,i=minRow;i<=maxRow;i++) {
                res.add(matrix[i][j]);
            }
            if(--maxColumn<minColumn)
                break;
            
            // from right to left
            for(i=maxRow,j=maxColumn;j>=minColumn;j--) {
                res.add(matrix[i][j]);
            }
            if(--maxRow<minRow)
                break;
            
            // from down to top
            for(i=maxRow,j=minColumn;i>=minRow;i--) {
                res.add(matrix[i][j]);
            }
            if(++minColumn>maxColumn)
                break;
        }
        
        return res;
    }
}

```