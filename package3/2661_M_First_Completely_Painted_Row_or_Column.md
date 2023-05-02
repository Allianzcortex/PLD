
Problem description:

```

You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.

 

Example 1:

image explanation for example 1
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
Example 2:

image explanation for example 2
Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].
 

Constraints:

m == mat.length
n = mat[i].length
arr.length == m * n
1 <= m, n <= 105
1 <= m * n <= 105
1 <= arr[i], mat[r][c] <= m * n
All the integers of arr are unique.
All the integers of mat are unique.

```

Basic Idea:

这道题题意和思路都挺直观的，就是 row 和 column 在 count 的时候容易混淆
需要思路非常清晰才可以

Python 解法如下：

```Python

class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        length = len(arr)

        match = {}

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                match[mat[i][j]] = (i,j)
        
        row_index = [0]*len(mat)
        column_index = [0]*len(mat[0])

        for i,num in enumerate(arr):
            x,y = match[num]
            row_index[x]+=1
            column_index[y]+=1

            if row_index[x]==len(mat[0]) or column_index[y]==len(mat):
                return i
        
        return -1

```