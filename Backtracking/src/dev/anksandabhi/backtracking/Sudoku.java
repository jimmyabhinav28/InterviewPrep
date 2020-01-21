package dev.anksandabhi.backtracking;

import java.util.Scanner;

public class Sudoku {

    private static boolean doesNumberSatisfySudokuConstraints(Integer[][] sudokuMaze, int row, int column, int num) {
        return isNumberUniqueInRow(sudokuMaze, row, column, num)
                && isNumberUniqueInColumn(sudokuMaze, row, column, num)
                && isNumberUniqueInItsGrid(sudokuMaze, row, column, num);

    }

    private static boolean isNumberUniqueInRow(Integer[][] sudokuMaze, int row, int column, int num) {
        for (int i = 0; i < sudokuMaze.length; i++) {
            if (column == i) continue;
            if (sudokuMaze[row][i].intValue() == num)
                return false;
        }
        return true;
    }

    private static boolean isNumberUniqueInColumn(Integer[][] sudokuMaze, int row, int column, int num) {

        for (int i = 0; i < sudokuMaze.length; i++) {
            if (row == i) continue;
            if (sudokuMaze[i][column].intValue() == num)
                return false;
        }
        return true;
    }

    private static boolean isNumberUniqueInItsGrid(Integer[][] sudokuMaze, int row, int column, int num) {
        int sqrt = (int) Math.sqrt(sudokuMaze.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = column - column % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (sudokuMaze[r][d].intValue() == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * empty cells to be filled with 0
     *
     * @param initialSudoku
     */
    public static boolean solveSudoku(Integer[][] initialSudoku) {
//        System.out.println("inside solve sudoku");

        //check if the sudoku is already solved..this is the recursion base case
        if (isSodukoSolved(initialSudoku))
            return true;

        for (int i = 0; i < initialSudoku.length; i++) {
            for (int j = 0; j < initialSudoku[0].length; j++) {
                if (initialSudoku[i][j].intValue() != 0) {
                    //this cell is already considered in the solution
                    continue;
                } else {
//                    System.out.println("Considering row:" + i + "  column:" + j + " for replacement");
                    for (int val = 1; val <= 9; val++) {
                        if (doesNumberSatisfySudokuConstraints(initialSudoku, i, j, val)) {
//                            System.out.println("looks like value of " + val + " might work");
                            initialSudoku[i][j] = new Integer(val);
                            if (!solveSudoku(initialSudoku)) {
//                                System.out.println("looks like  " + val + " did not work");
                                continue;
                            } else {
//                                System.out.println("looks like  " + val + " worked");
                                return true;
                            }
                        }
                        //try the next value

                    }
//                    System.out.println("nothing worked for the cell with row: "+i+" and column: "+j+" ..backtracking");
                    initialSudoku[i][j] = new Integer(0);
                    return false;
                }

            }
        }

        return false;

    }

    public static Integer[][] inputInitialSudoku() {
        Integer[][] sudokuMatrix = new Integer[9][9];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input matrix now");
        boolean moreInputs = false;
        do {
            System.out.println("Enter cell row");
            Integer row = scanner.nextInt();
            System.out.println("Enter cell column");
            Integer column = scanner.nextInt();
            System.out.println("Enter cell value");
            Integer val = scanner.nextInt();
            sudokuMatrix[row.intValue()][column.intValue()] = val.intValue();
            System.out.println("Do you want to continue? enter 0 to stop");
            val = scanner.nextInt();
            if (val.intValue() == 0)
                moreInputs = false;
            else
                moreInputs = true;
        }
        while (moreInputs);
        return sudokuMatrix;
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
//        System.out.println("Sudoku is solved");
        return true;
    }

}
