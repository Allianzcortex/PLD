Problem description :

```
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

```

Below is Java solution:

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

Below is Python solution:

`以右上(solution 1)或者左下(solution 2)为起点来查找`

solution 1

```Python

class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix)==0:
            return False
        row,column = len(matrix),len(matrix[0])
        x,y = 0,column-1

        while x>=0 and x<row and y>=0 and y<column:
            if matrix[x][y] == target:
                return True
            elif matrix[x][y] < target:
                # should increase , from top to down
                x+=1
            else:
                # should decrease, from right to left
                y-=1
        
        return False

```

solution 2

```Python

class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if matrix is None or len(matrix)==0:
            return False
        row,column = len(matrix),len(matrix[0])
        x,y = row-1, 0

        while x>=0 and x<row and y>=0 and y<column:
            if matrix[x][y] == target:
                return True
            elif matrix[x][y] < target:
                # should increase , from left to right
                y+=1
            else:
                # should decrease, from down to top
                x-=1
        
        return False

```

Time Complexity is O(M+N):M is the row number, N is che column number
Space Complextiy is O(1): for it only needs 2 pointers