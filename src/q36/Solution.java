package q36;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row[] = new HashSet[9];
        Set<Character> column[] = new HashSet[9];
        Set<Character> block[] = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            block[i] = new HashSet<>();
        }
        //比较行列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char value = board[i][j];
                    if (row[i].contains(value)) {
                        System.out.println("row"+i+j);
                        return false;
                    } else {
                        row[i].add(value);
                    }
                    if (column[j].contains(value)) {
                        System.out.println("column"+i+j);
                        return false;
                    } else {
                        column[j].add(value);
                    }
                    if (block[(i / 3) * 3 + (j / 3)].contains(value)) {
                        System.out.println("block"+i+j);
                        return false;
                    } else {
                        block[(i / 3) * 3 + (j / 3)].add(value);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] chs = new char[9][9];
    }
}
