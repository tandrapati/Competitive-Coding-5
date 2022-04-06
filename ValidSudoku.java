/**
 * time complexity is O(n*2)
 * space complexity is O(n*3)
 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }
                if (rows[i].contains(val)) {
                    return false;
                }
                rows[i].add(val);
                if (cols[j].contains(val)) {
                    return false;
                }
                cols[j].add(val);
                int idx = (i / 3) * 3 + j / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}