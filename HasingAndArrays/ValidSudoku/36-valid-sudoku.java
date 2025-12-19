import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROWS = 9;
        int COLS = 9;
        Set<Character>[] rowChecker = new HashSet[ROWS];
        Set<Character>[] colChecker = new HashSet[COLS];
        Set<Character>[] subBoxChecker = new HashSet[ROWS];

        for (int i = 0; i < ROWS; i++) {
            rowChecker[i] = new HashSet<>();
            colChecker[i] = new HashSet<>();
            subBoxChecker[i] = new HashSet<>();
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == '.')
                    continue;

                if (!rowChecker[i].add(board[i][j]) ||
                        !colChecker[j].add(board[i][j]) ||
                        !subBoxChecker[((i / 3) * 3) + (j / 3)].add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;

    }
}