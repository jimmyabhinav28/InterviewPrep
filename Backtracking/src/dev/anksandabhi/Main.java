package dev.anksandabhi;

import dev.anksandabhi.backtracking.NQueens;
import dev.anksandabhi.backtracking.Sudoku2;
import dev.anksandabhi.recursion.NDoorsMKeyProblem;
import dev.anksandabhi.recursion.RatsMazeWhenMovementIsAllowedInAllDirections;
import dev.anksandabhi.recursion.SimplestRatInAMaze;
import dev.anksandabhi.utils.MatrixUtils;

public class Main {
    private static MatrixUtils<Integer> integerMatrixUtils = new MatrixUtils<Integer>();

    public static void main(String[] args) {
//        testSudoku();
//        testNQueens();
//        testSimpleRatInAMazeSinglePath();
//        testSimpleRatInAMazeAllPath();
//        testNDoorsMKeys();
        testRatsMazeAllDirections();
    }

    public static void testNQueens() {
        Integer[][] maze = new Integer[5][5];
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<Integer>();

        matrixUtils.initialise2DIntegerMatrixWithZeros(maze);
        NQueens.solveNQueens(maze, maze.length);
        matrixUtils.print2DMatrix(maze);

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


        Sudoku2.solveSudoku(initialSudoku);
//        System.out.println("\n\nSolved Sudoku is\n\n ");
        integerMatrixUtils.print2DMatrix(initialSudoku);


    }

    public static void testSimpleRatInAMazeSinglePath() {
        Integer[][] maze =
                       {{1, 0, 0, 0,0},
                        {1, 1, 1, 1,1},
                        {0, 1, 0, 1,1},
                        {1, 1, 1, 0,1}};

        SimplestRatInAMaze.solveRatInMazeSinglePath(maze, 0, 0);
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<Integer>();
        matrixUtils.print2DMatrix(maze);

    }

    public static void testSimpleRatInAMazeAllPath() {
        Integer[][] maze =
                {{1, 0, 0, 0,0},
                        {1, 1, 1, 1,1},
                        {0, 1, 0, 1,1},
                        {1, 1, 1, 0,1}};

        SimplestRatInAMaze.solveRatInMazeAllPaths(maze, 0, 0);
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<Integer>();
        matrixUtils.print2DMatrix(maze);

    }

    public static void testNDoorsMKeys()
    {
        Integer[][]maze={
                {0, 0, 1,1},
                {1, 0, 1,1},
                {1, 1, 1,0}
        };

        boolean isFeasible=NDoorsMKeyProblem.canReachLastCellWithAtMaxMKeys(maze,2);
        System.out.println(isFeasible);
    }

    public static void testRatsMazeAllDirections()
    {
        Integer[][]maze={
                {1, 0, 0,0},
                {1, 1, 0,1},
                {1, 1, 0,0},
                {0, 1, 1,1}
        };

        RatsMazeWhenMovementIsAllowedInAllDirections.findAPathWhenAllDirectionsAreAllowed(maze);
    }

}
