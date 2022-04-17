
Classic problem in CC150.

Iterate from 4 directions,and break when its over the bound.

Problem Description:

```
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

```

Basic idea : 就是顺序循环，然后调整好 up/right,top/bottom 的边界

---

Below is Java Solution :

```Java

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int minRow=0,maxRow=matrix.length-1,minColumn=0,maxColumn=matrix[0].length-1;
        
        int index = 0;
        int i,j;
        while(true) {
            // left to right
            for(i = minRow,j=minColumn;j<=maxColumn;j++) {
                res.add(matrix[i][j]);
            }
            if(++minRow>maxRow)
                break;
            
            // from top to down
            for(j=maxColumn,i=minRow;i<=maxRow;i++) {
                res.add(matrix[i][j]);
            }
            if(--maxColumn<minColumn)
                break;
            
            // from right to left
            for(i=maxRow,j=maxColumn;j>=minColumn;j--) {
                res.add(matrix[i][j]);
            }
            if(--maxRow<minRow)
                break;
            
            // from down to top
            for(i=maxRow,j=minColumn;i>=minRow;i--) {
                res.add(matrix[i][j]);
            }
            if(++minColumn>maxColumn)
                break;
        }
        
        return res;
    }
}

```

---

And here is Python version :

```Python

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        min_row,max_row = 0,len(matrix)-1
        min_column,max_column = 0,len(matrix[0])-1
        
        index = 0
        res = []
        i,j = 0,0
        while True:
            
            # case 1 : from left->right
            for i in range(min_column,max_column+1):
                res.append(matrix[min_row][i])
            min_row += 1
            if min_row>max_row:
                break
            
            # case 2 : from top->down
            for i in range(min_row,max_row+1):
                res.append(matrix[i][max_column])
            max_column -= 1
            if max_column<min_column:
                break
            
            # case 3 : from right->left
            for i in range(max_column,min_column-1,-1):
                res.append(matrix[max_row][i])
            max_row -= 1
            if max_row < min_row:
                break
            
            # case 4 : from down->top
            for i in range(max_row,min_row-1,-1):
                res.append(matrix[i][min_column])
            min_column += 1
            if min_column>max_column:
                break
        
        return res

```

对应的 Golang 解法如下：

```Golang

func spiralOrder(matrix [][]int) []int {
    
    row,column := len(matrix),len(matrix[0])
    res := make([]int,row*column)
    
    // define the bound
    top,bottom := 0,row-1
    left,right := 0,column-1
    index := 0
    
    for {
        
        // direction 1 : from left to right
        for i:=left;i<=right;i++ {
            res[index] = matrix[top][i]
            index += 1
        }
        top += 1
        if top > bottom {
            break;
        }
        
        // direction 2 : from top to down
        for i:=top;i<=bottom;i++ {
            res[index] = matrix[i][right]
            index += 1
        }
        right -= 1
        if right<left {
            break
        }
        
        // direction 3 : from right to left
        for i:=right;i>=left;i-- {
            res[index] = matrix[bottom][i]
            index += 1
        }
        bottom -= 1
        if bottom < top {
            break
        }
        
        // direction 4 : from down to bottom
        for i:=bottom;i>=top;i-- {
            res[index] = matrix[i][left]
            index += 1
        }
        left += 1
        if left>right {
            break
        }
        
    }
    
    return res
    
}

```