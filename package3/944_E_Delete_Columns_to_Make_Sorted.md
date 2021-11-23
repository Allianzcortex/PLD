
Problem description:

```
You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:

abc
bce
cae
You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

Return the number of columns that you will delete.

 

Example 1:

Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
Example 2:

Input: strs = ["a","b"]
Output: 0
Explanation: The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.
Example 3:

Input: strs = ["zyx","wvu","tsr"]
Output: 3
Explanation: The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.
 

Constraints:

n == strs.length
1 <= n <= 100
1 <= strs[i].length <= 1000
strs[i] consists of lowercase English letters.

```

Basic idea:

这是自己一开始的解法：

```Python

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        
        row,column = len(strs),len(strs[0])
        matrix = [[0]*row for _ in range(column)]
        
        for i in range(row):
            for j in range(column):
                matrix[j][i] = strs[i][j]
        
        cnt = 0
        for i in range(column):
            j = 1
            
            while j<row:
                if matrix[i][j]<matrix[i][j-1]:
                    cnt += 1
                    break
                j+=1

        return cnt        

```

最后一看，根本没必要创造 matrix 这个 array，可以直接比较的啊......时空复杂度都有大幅提升
代码如下：

```Python

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        
        row,column = len(strs),len(strs[0])
        
        cnt = 0
        for i in range(column):
            for j in range(1,row):
                if strs[j][i]<strs[j-1][i]:
                    cnt += 1
                    break
        return cnt

```