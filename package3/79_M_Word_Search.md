


```Java
class Solution {
    
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word==null || word.length()==0)
            return false;
        boolean[][] used =new boolean[board.length][board[0].length];
        char start=word.charAt(0);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                    if(exists(board,word,used,i,j,0))
                        return true;
            }
        }
        
        return false;
        
    }
    
    public boolean exists(char[][] board,String word,boolean[][] used,int i,int j,int index) {
        if(index>=word.length()) {
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || used[i][j] || board[i][j]!=word.charAt(index))
            return false;
        used[i][j]=true;
        boolean flag=
            exists(board,word,used,i,j+1,index+1) ||
            exists(board,word,used,i,j-1,index+1) ||
            exists(board,word,used,i-1,j,index+1) ||
            exists(board,word,used,i+1,j,index+1);
        used[i][j]=false;
        return flag;
        
    }
}

```