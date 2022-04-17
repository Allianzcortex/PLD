
Problem description:

```

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

```


思路：

一种思路是把整个矩阵当成一个有序数列，类似思路如下：

```

n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

```

这种方法自己之后再实现。


另一种就是更常规的思路，先用二分搜索搜索行，在确定这个数就在某一行后再用二分搜索搜索列

```Python

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        up,bottom = 0,len(matrix)-1
        
        while up<=bottom:
            middle = up + (bottom-up) // 2
            

            if matrix[middle][0]==target:
                return True
            elif matrix[middle][0]<target:
                up = middle + 1
            else:
                bottom = middle-1
        
        # now bottom should be the line

        left,right = 0,len(matrix[0])-1

        while left<=right:
            middle = left+(right-left) // 2
            
            if matrix[bottom][middle]==target:
                return True
            elif matrix[bottom][middle]<target:
                left = middle + 1
            else:
                right = middle - 1
        
        return False

```