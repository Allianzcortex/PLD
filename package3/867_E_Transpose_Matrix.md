
Problem description:

```

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.


Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109

```

Basic idea:

这道题开始自己还以为是 `package1 / 01.07` 的 Matrix Rotate...
归不得怎么都找不到规律

anyway 矩阵转置还是很直观的,把 x/y 坐标轴互换：

```Python

class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        
        row,column = len(matrix),len(matrix[0])
        res = [[0]*row for _ in range(column)]
        
        for i in range(row):
            for j in range(column):
                res[j][i] = matrix[i][j]
        
        return res

```