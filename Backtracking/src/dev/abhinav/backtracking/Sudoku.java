package dev.abhinav.backtracking;

import java.util.Scanner;

public class Sudoku {

    private static boolean doesNumberSatisfySudokuConstraints(int[][] sudokuMaze, int row, int column, int num) {
        return isNumberUniqueInRow(sudokuMaze, row, column, num) && isNumberUniqueInColumn(sudokuMaze, row, column, num) && isNumberUniqueInItsGrid(sudokuMaze, row, column, num);

    }

    private static boolean isNumberUniqueInRow(int[][] sudokuMaze, int row, int column, int num) {
        for (int i = 0; i < sudokuMaze.length; i++) {
            if (column == i) continue;
            if (sudokuMaze[row][i] == num)
                return false;
        }
        return true;
    }

    private static boolean isNumberUniqueInColumn(int[][] sudokuMaze, int row, int column, int num) {

        for (int i = 0; i < sudokuMaze.length; i++) {
            if (row == i) continue;
            if (sudokuMaze[i][column] == num)
                return false;
        }
        return true;
    }

    private static boolean isNumberUniqueInItsGrid(int[][] sudokuMaze, int row, int column, int num) {
        int sqrt = (int) Math.sqrt(sudokuMaze.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = column - column % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (sudokuMaze[r][d] == num) {
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
    public static boolean solveSudoku(int[][] initialSudoku) {

        int[][] sudokuIntialMatrix = inputInitialSudoku();
        for(int i=0;i<sudokuIntialMatrix.length;i++)
        {
            for(int j=0;j<sudokuIntialMatrix[0].length;j++)
            {
                if(sudokuIntialMatrix[i][j]!=0)
                    continue;
                else
                {
                    for(int val=1;val<9;val++)
                    {
//                        sudokuIntialMatrix[i][j]=val;
                        if(doesNumberSatisfySudokuConstraints(initialSudoku,i,j,val))
                        {
                            return solveSudoku(initialSudoku);
                        }

                    }
                }
            }
        }

    }

    public static int[][] inputInitialSudoku() {
        int[][] sudokuMatrix = new int[9][9];
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

}
