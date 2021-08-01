
Problem description:

```

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

```

这里有两种解法，第一种是自己想的，也是最直观的，就是每一层在一个位置放 'Q'，然后检测这个位置是否合理：
检测时要注意：

1. 因为是在新的一层，所以 row 当然不用检测
2. 需要检测 column
3. 需要检测对角线，其中有左上和右上两个方向

解法如下：

```Python

class Solution:
    from copy import deepcopy
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.']*n for _ in range(n)]
        
        res = []
        
        self.dfs(board,res,n,0)
        
        return res
    
    def dfs(self,board,res,n,layer):
        if layer>len(board)-1:
            # res.append(deepcopy(board))
            res.append(["".join(row) for row in board])
            return
        
        for j in range(n):
            board[layer][j] = 'Q'
            if self.check(board,layer,j):
                self.dfs(board,res,n,layer+1)
            board[layer][j] = '.'
    
    def check(self,board,i,j):
        
        # check  column 
        for x in range(i):
            if board[x][j] == 'Q':
                return False
        
        # check diagonal
        x1,y1 = i-1,j-1
        
        while x1>=0 and y1>=0:
            if board[x1][y1]=='Q':
                return False
            x1-=1
            y1-=1
        
        x2,y2 = i-1,j+1
        while x2>=0 and y2<=len(board)-1:
            if board[x2][y2]=='Q':
                return False
            x2-=1
            y2+=1
        
        return True
```

第二种思路会更精确一点，也会占用更少的空间：

就是用一个数组 temp[] 来存储每一行的选择，比如 temp = [1,3,2]
那么就说明在第一行选择第一列，第二行选择第三列，第三行选择第二列

具体可以参见这个链接：
https://leetcode.com/problems/n-queens/discuss/19971/Python-recursive-dfs-solution-with-comments.

自己到时候也要实现一遍

---

My Java Solution : 

```Java

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row:board)
            Arrays.fill(row,'.');
        List<List<String>> res = new ArrayList<>();
        dfs(board,0,n,res);
        return res;
        
    }
    
    public void dfs(char[][] board,int index,int n,List<List<String>> res) {
        if(index==n) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                temp.add(String.valueOf(board[i]));
            }
            res.add(temp);
            return;
        }
        
        // LOL,a mistake here,no need to iterate over the index
        // for(int i=index;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(judge(board,n,index,j)) {
                    board[index][j] = 'Q';
                    dfs(board,index+1,n,res);
                    board[index][j] = '.';
                }
            }
        // }
    
    }
    
    public boolean judge(char[][] board,int n,int x,int y) {
       
        // check y ,no need to check x for we add row by row
        for(int i=0;i<x;i++) {
            if(board[i][y]=='Q')
                return false;
        }
        
        // check diagonal
        int i=x,j=y;
        while(i>=0 && j<n) {
            if(board[i--][j++]=='Q')
                return false;
        }
        
        while(x>=0 && y>=0) {
            if(board[x--][y--]=='Q')
                return false;
        }
        
        return true;
    }
}


```