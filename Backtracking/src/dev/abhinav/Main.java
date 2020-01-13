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


        Sudoku.solveSudoku(initialSudoku);
//        System.out.println("\n\nSolved Sudoku is\n\n ");
        integerMatrixUtils.print2DMatrix(initialSudoku);


    }

}
