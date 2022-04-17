
Probelm description:

```
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

```

思路：

双向递增，可以从右上或者左下开始搜索

Python Solution :

```Python

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # choose top right value
        if not matrix or not matrix[0]:
            return False
        
        i,j = 0,len(matrix[0])-1
        
        while True:

            if i<0 or i>len(matrix)-1 or j<0 or j>len(matrix[0])-1:
                break
            
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                # find a bigger one
                i+=1
            else:
                # find a smaller one
                j-=1
        
        return False

```