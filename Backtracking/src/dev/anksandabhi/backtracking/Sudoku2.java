package dev.anksandabhi.backtracking;

public class Sudoku2 {
    private static boolean doesNumberSatisfySudokuConstraints(Integer[][] sudokuMaze, int row, int column, int num) {
        return isNumberUniqueInRow(sudokuMaze, row, column, num)
                && isNumberUniqueInColumn(sudokuMaze, row, column, num)
                && isNumberUniqueInItsGrid(sudokuMaze, row, column, num);

    }

    private static boolean isNumberUniqueInColumn(Integer[][] sudoku, int row, int column, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if (row == i) continue;
            if (sudoku[i][column].intValue() == num)
                return false;
        }
        return true;
    }

    private static boolean isNumberUniqueInRow(Integer[][] sudoku, int row, int column, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if (column == i) continue;
            if (sudoku[row][i].intValue() == num)
                return false;
        }
        return true;
    }

    private static boolean isNumberUniqueInItsGrid(Integer[][] sudoku, int row, int column, int num) {
        int sqrt = (int) Math.sqrt(sudoku.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = column - column % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (sudoku[r][d].intValue() == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(Integer[][] sudoku) {

        System.out.println("inside solve sudoku");

        if (isSodukoSolved(sudoku))
            return true;

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] != 0)
                    continue;
                else {
                    //you need to fill this entry by computation
                    for (int val = 1; val <= 9; val++) {
                        if (doesNumberSatisfySudokuConstraints(sudoku, i, j, val)) {
                            sudoku[i][j] = val;
                            if (solveSudoku(sudoku)) {
                                //there is a solution here
                                return true;
                            } else {
                                //do nothing
                            }
                        } else {
                            //do nothing
                        }
                    }
                    sudoku[i][j] = 0;//backtracking
                    return false;
                }
            }
        }
        return false;//no true returned before, no solution can be arrived at
    }

    /**
     * Sudoku is solved if there are no more zeros
     *
     * @param sudokuMatrix
     * @return
     */
    private static boolean isSodukoSolved(Integer[][] sudokuMatrix) {

        for (int i = 0; i < sudokuMatrix.length; i++) {
            for (int j = 0; j < sudokuMatrix.length; j++) {
                if (sudokuMatrix[i][j] == 0)
                    return false;

            }
        }
        return true;
    }

}
