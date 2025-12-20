class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROWS = 9;
        int COLS = 9;
        int[] rowChecker = new int[9];
        int[] colChecker = new int[9];
        int[] subBoxChecker = new int[9];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == '.')
                    continue;

                char c = board[i][j];

                int mask = 1 << (c - '1');

                if ((rowChecker[i] & mask) != 0
                        || (colChecker[j] & mask) != 0
                        || (subBoxChecker[((i / 3) * 3) + (j / 3)] & mask) != 0) {
                    return false;
                }

                rowChecker[i] |= mask;
                colChecker[j] |= mask;
                subBoxChecker[((i / 3) * 3) + (j / 3)] |= mask;
            }
        }

        return true;

    }
}