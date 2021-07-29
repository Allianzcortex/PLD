
Problem description:

```
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

```

Basic idea :

Firstly the most intuitive solution : with O(m+n) space:

```Python

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        
        zero_rows , zero_columns = set(),set()
        row,column = len(matrix),len(matrix[0])
        
        for i in range(row):
            for j in range(column):
                if matrix[i][j] == 0:
                    zero_rows.add(i)
                    zero_columns.add(j)
        
        for i in range(row):
            for j in range(column):
                if i in zero_rows or j in zero_columns:
                    matrix[i][j] = 0
```

Secondly it's using O(1) space :

思路是每遇到一个 0 ，就把这个元素的第一行第一个元素和这个元素的第一列第一个元素标 0，
然后在第二轮循环里根据首个元素来跟新 0.

这样的一个问题就是对第一行和第一列，首个元素都是 [0,0] 可能会造成重叠，所以专门用
is_first_row_zero 和 is_first_column_zero 两个变量来计算第一行和第一列是否应该
标 0.

```Python

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        
        """
        
        is_first_row_zero , is_first_column_zero = False,False
        
        row,column = len(matrix),len(matrix[0])
        
        for i in range(row):
            for j in range(column):
                if matrix[i][j] == 0:
                    # handle first row / first column specifically
                    if i==0 or j==0:
                        if i==0:
                            is_first_row_zero = True
                        if j==0:
                            is_first_column_zero = True
                        continue
                    else:
                        matrix[i][0] = 0
                        matrix[0][j] = 0
        
        for i in range(1,row):
            for j in range(1,column):
                if matrix[i][0]==0 or matrix[0][j]==0:
                    matrix[i][j] = 0
        
        if is_first_row_zero:
            matrix[0] = [0]*column
        
        if is_first_column_zero:
            for i in range(row):
                matrix[i][0] = 0

```