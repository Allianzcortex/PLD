
Two solutions:DFS/BFS

Java

The key is to follow the description : 

```
If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
```

1. DFS:

```Java
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        solve(board,click[0],click[1]);
        return board;
    }

    public void solve(char[][] board,int i,int j) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;
        
        // case 1
        if(board[i][j]=='M') {
            board[i][j]='X';
            return;
        }

        // case 2
        if(board[i][j]=='E') {
            int adjacentMinesCount = 0;
            for(int k=-1;k<=1;k++) {
                for(int l=-1;l<=1;l++) {
                    adjacentMinesCount += getAdjacentMinesCount(board,i+k,j+l);
                }
            }

            if(adjacentMinesCount == 0) {
                board[i][j] = 'B';
                for(int k=-1;k<=1;k++) {
                   for(int l=-1;l<=1;l++) {
                    int newX=i+k,newY = j+l;
                    if(newX<0 || newX>=board.length || newY<0 || newY>=board[0].length)
                        continue;
                    // all of its adjacent unrevealed squares should be revealed recursively.
                    // So we should check whether its 'E' firstly
                    if(board[newX][newY]=='E')
                        solve(board,newX,newY);
                }
                }
            } else {
                board[i][j] = Character.forDigit(adjacentMinesCount,10);
            }
        }
    }

    public int getAdjacentMinesCount(char[][] board,int i,int j) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return 0;
        if(board[i][j]=='M')
            return 1;
        return 0;
    }
}

```

2. BFS Solution

```Java

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        int row = board.length,column = board[0].length;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x=cur[0],y=cur[1];

            // case 1
            if(board[x][y]=='M') {
                board[x][y]='X';
            }

            // case 2
            if(board[x][y]=='E') {
                // two situations
                // we need to find the adjacent amount fist
                int adjacetMineCount = 0;
                for(int i=-1;i<=1;i++) {
                    for(int j=-1;j<=1;j++) {
                        int newX = x+i,newY=y+j;
                        if(newX<0 || newX>=row || newY<0 || newY>=column) {
                            continue;
                        }
                        if(board[newX][newY]=='M')
                            adjacetMineCount += 1;
                    }
                }

                if(adjacetMineCount>0) {
                    board[x][y] = (char) (adjacetMineCount+'0');
                } else {
                    board[x][y] = 'B';
                    for(int i=-1;i<=1;i++) {
                        for(int j=-1;j<=1;j++) {
                        int newX = x+i,newY=y+j;
                        if(newX<0 || newX>=row || newY<0 || newY>=column) {
                            continue;
                        }
                        if(board[newX][newY]=='E'){
                            queue.add(new int[]{newX,newY});
                        }
                    }
                    }
                }
            }

        }

        return board;
    }
}

```