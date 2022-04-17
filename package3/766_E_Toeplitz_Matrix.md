
Problem description:

```

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

 

Example 1:


Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:


Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 20
0 <= matrix[i][j] <= 99
 

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?

```

Basic idea:

自己一开始的想法如下，是比较每一个对角的值：

```Python

class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        
        row,column = len(matrix),len(matrix[0])
        
        def isValid(matrix,x,y):
            
            target = matrix[x][y]
            
            while x<row and y<column:
                if matrix[x][y]!=target:
                    return False
                x+=1
                y+=1

            return True
        
        coordinates = [(x,0) for x in range(row)]
        coordinates.extend([(0,y) for y in range(1,column)])
        
        for x,y in coordinates:
            if not isValid(matrix,x,y):
                return False
        
        return True

```

其实是有点繁琐的实现，直接比较所有的值是否都和右下角的值相等就行
对应的实现如下：

```Python

class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        
        row,column = len(matrix),len(matrix[0])
        
        for i in range(row-1):
            for j in range(column-1):
                if matrix[i][j]!=matrix[i+1][j+1]:
                    return False
        
        return True

```