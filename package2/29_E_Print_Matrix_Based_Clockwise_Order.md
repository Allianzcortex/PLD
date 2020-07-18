

```Java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        /**
            1 2 3
            4 5 6
            7 8 9

            1 2  3  4
            5 6  7  8
            9 10 11 12

        **/
        if(matrix==null || matrix.length==0)
            return new int[]{};
        int left=0,right=matrix[0].length-1,top=0,down=matrix.length-1;
        int index=0;
        int[] res=new int[(right+1)*(down+1)];
        while(true) {
            // round 1
            for(int i=left;i<=right;i++)
                res[index++]=matrix[top][i];
            if(++top>down)
                break;
            
            // round 2
            for(int i=top;i<=down;i++)
                res[index++]=matrix[i][right];
            if(--right<left)
                break;
            
            // round 3
            for(int i=right;i>=left;i--)
                res[index++]=matrix[down][i];
            if(--down<top)
                break;
            
            // round 4
            for(int i=down;i>=top;i--)
                res[index++]=matrix[i][left];
            if(++left>right)
                break;
        }

        return res;
        
    }
}

```