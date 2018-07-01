/**
 * Created by xixi on 2018/5/11.
 */
public class leetcode79 {
    private boolean find(char[][] board, boolean[][] used, char[] wa, int pos, int row, int col) {
        if (pos == wa.length) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) return false;
        if (used[row][col]) return false;
        if (wa[pos] != board[row][col]) return false;
        used[row][col] = true;
        if (find(board, used, wa, pos+1, row, col-1)) return true;
        if (find(board, used, wa, pos+1, row, col+1)) return true;
        if (find(board, used, wa, pos+1, row-1, col)) return true;
        if (find(board, used, wa, pos+1, row+1, col)) return true;
        used[row][col] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] wa = word.toCharArray();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if (find(board, used, wa, 0, i, j)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        new leetcode79().exist(board,"ABCCED");
    }
}
