
Problem description:

```

Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 

Example 1:


Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

```

Idea : 这道题来自于 303 的一维 query sum
这道题要注意计算 prefix 和计算最终 sum 时都有相同的公式

Python solution:

```Python

class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        row,column = len(matrix),len(matrix[0])
        
        self.prefix = [[0]*(column+1) for _ in range(row+1)]
        
        for i in range(1,row+1):
            for j in range(1,column+1):
                self.prefix[i][j]=self.prefix[i-1][j]+self.prefix[i][j-1]-self.prefix[i-1][j-1]+matrix[i-1][j-1]
        
        print(self.prefix)

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        
        return self.prefix[row2+1][col2+1]-self.prefix[row2+1][col1]-self.prefix[row1][col2+1] + self.prefix[row1][col1]
        
```

---

Golang Solution :

```Golang

type NumMatrix struct {
    prefix [][]int;
}


func Constructor(matrix [][]int) NumMatrix {
    
    row:=len(matrix)
    column:=len(matrix[0])
    
    prefix:=make([][]int,row+1)
    
    for i:= range prefix {
        prefix[i] = make([]int,column+1)
    }
    
    for i:=1;i<=row;i++ {
        for j:=1;j<=column;j++ {
            prefix[i][j] = prefix[i-1][j] + prefix[i][j-1]-prefix[i-1][j-1]+matrix[i-1][j-1]
        }
    }
    
    return NumMatrix{prefix:prefix}
}


func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
    
    prefix := this.prefix
    
    return prefix[row2+1][col2+1]-prefix[row2+1][col1]-prefix[row1][col2+1]+prefix[row1][col1]
}

```