
Classic DFS problem

```Java
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr=word.toCharArray();
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==arr[0])
                    if(traverse(board,arr,visited,i,j,0))
                        return true;
            }
        }

        return false;
    }

    public boolean traverse(char[][] board,char[] arr,boolean[][] visited,int i,int j,int index) {
        System.out.println("i " + i +" j " +j);
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || index>arr.length
        || visited[i][j] || board[i][j]!=arr[index])
            return false;
        if(index==arr.length-1)
            return true;
        visited[i][j]=true;
        boolean flag=(traverse(board,arr,visited,i+1,j,index+1) ||
        traverse(board,arr,visited,i-1,j,index+1) ||
        traverse(board,arr,visited,i,j+1,index+1) || 
        traverse(board,arr,visited,i,j-1,index+1));
        visited[i][j]=false;
        return flag;
    }
}

```