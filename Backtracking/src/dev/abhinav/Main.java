package dev.abhinav;

import dev.abhinav.backtracking.Sudoku;
import dev.abhinav.utils.MatrixUtils;

public class Main {
    private static MatrixUtils<Integer> integerMatrixUtils = new MatrixUtils<Integer>();

    public static void main(String[] args) {
        testSudoku();
    }

    public static void testSudoku() {
        Integer[][] initialSudoku = new Integer[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };

       /* Integer[][] initialSudoku = new Integer[][]
                {{3, 1, 6, 5, 7, 8, 4, 9, 2},
                        {5, 2, 9, 1, 3, 4, 7, 6, 8},
                        {4, 8, 7, 6, 2, 9, 5, 3, 1},
                        {2, 6, 3, 4, 1, 5, 9, 8, 7},
                        {9, 7, 4, 8, 6, 3, 1, 2, 5},
                        {8, 5, 1, 7, 9, 2, 6, 4, 3},
                        {1, 3, 8, 9, 4, 7, 2, 5, 6},
                        {6, 9, 2, 3, 5, 1, 8, 7, 4},
                        {7, 4, 5, 2, 8, 6, 3, 1, 9}};*/

        Sudoku.solveSudoku(initialSudoku);
        System.out.println("\n\nSolved Sudoku is\n\n ");
        integerMatrixUtils.print2DMatrix(initialSudoku);


    }

}
