
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

And Here is another Python implementation, but difference is :
it swaps row value(top and bottom) based on middle line, and then
swap value based on diagonal.

In the interivew, any solution will work:

```Python

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        swap the value based on diagonal
        
        1 2 3     7 8 9    7 4 1
        4 5 6 ->  4 5 6 -> 8 5 2
        7 8 9     1 2 3    9 6 3
        
        """
        
        
        row = len(matrix)
        if row == 0:
            return
        column = len(matrix[0])
        
        up,bottom = 0,row-1
        
        # step 1 : swap row value based on middle line
        while up<bottom:
            for j in range(column):
                matrix[up][j],matrix[bottom][j] = matrix[bottom][j],matrix[up][j]
            up += 1
            bottom -= 1
        
        # step 2 : swap value based on diagonal
        
        for i in range(row):
            for j in range(0,i):
                matrix[i][j],matrix[j][i] = matrix[j][i],matrix[i][j]
```