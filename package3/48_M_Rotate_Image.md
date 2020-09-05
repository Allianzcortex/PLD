
The whole idea is pretty simple. we swap the symmetry firstly
and then swap the left and right column.

// if we want to do anticlockwise,we still swap the symmetry and
// then swap the up and down row

Classic rotate matrix problem

Java Solution

```Java
class Solution {
    public void rotate(int[][] matrix) {
        /**
        1 2 3
        4 5 6 
        7 8 9   
        
        1 4 7
        2 5 8 ------> step1 swap the symmetry
        3 6 9
        
        7 4 1
        8 5 2 ------> step2 swap the left and right column
        9 6 3
        
        **/
        
        int row=matrix.length;
        for(int i=0;i<row;i++) {
            for(int j=0;j<i;j++) {
                swap(matrix,i,j,j,i);
            }
        }
        
        for(int i=0;i<row/2;i++) {
            for(int j=0;j<row;j++) {
                swap(matrix,j,i,j,row-1-i);
            }
        }
        
    }
    
    public void swap(int[][] matrix,int i,int j,int k,int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}


```

This is Python implementation

```Python
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        row = len(matrix)
        for i in range(0,row):
            for j in range(0,i):
#                 swap matrix[j][i] and matrix[i][j]
                matrix[j][i],matrix[i][j] = matrix[i][j],matrix[j][i]
        
        for i in range(0,row//2):
            for j in range(0,row):
                # // swap matrix[i] and matrix[row-1-i]
                matrix[j][i],matrix[j][row-1-i] = matrix[j][row-1-i],matrix[j][i]
        


```