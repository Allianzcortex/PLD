/**
 * 但还是有其他办法，比如用一个一维数组来存储，这样效率会更高
 */
public class NQueuens {
    int[][] arr;
    int length;

    public NQueuens(int N) {
        arr = new int[N][N];
        this.length = N;
    }

    public boolean judge(int row, int col) {
        int i, j;
        if (row < 0 || row > length || col < 0 || col > length)
            return false;
        // 检测左边
        for (i = 0; i < col; i++) {
            if (arr[row][i] == 1)
                return false;
        }
        // 检测对角线
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (arr[i][j] == 1)
                return false;
        for (i = row, j = col; i < length && j >= 0; i++, j--)
            if (arr[i][j] == 1)
                return false;
        return true;
    }

    public boolean solve(int col) {
        if (col >= length) {
            printSolution();
            //return true; 不加上这一句就
        }
        for (int i = 0; i < length; i++) {
            if (judge(i, col)) {
                arr[i][col] = 1;
                if (solve(col + 1))
                    return true;
                // 返回原值
                arr[i][col] = 0;
            }
        }
        return false;
    }

    public void printSolution() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueuens nQueuens = new NQueuens(4);
        nQueuens.solve(0);

        String s="abcdefg";
        System.err.println(s.charAt(0));
        char[] temp=s.toCharArray();
        System.out.println(temp.length);
        for(char c:temp){
            System.out.println(c);
        }
    }
}

