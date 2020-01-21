package dev.anksandabhi;

import dev.anksandabhi.backtracking.NQueens;
import dev.anksandabhi.backtracking.Sudoku2;
import dev.anksandabhi.recursion.NDoorsMKeyProblem;
import dev.anksandabhi.recursion.RatsMazeWhenMovementIsAllowedInAllDirections;
import dev.anksandabhi.recursion.SimplestRatInAMaze;
import dev.anksandabhi.recursion.SlotsAndOptions;
import dev.anksandabhi.utils.MatrixUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static MatrixUtils<Integer> integerMatrixUtils = new MatrixUtils<Integer>();

    public static void main(String[] args) {
//        testSudoku();
//        testNQueens();
//        testSimpleRatInAMazeSinglePath();
//        testSimpleRatInAMazeAllPath();
//        testNDoorsMKeys();
//        testRatsMazeAllDirections();
        testNSlotsMOptionsInteger();
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

   /* public static void testRatsMazeAllDirections()
    {
        Integer[][]maze={
                {1, 0, 0,0},
                {1, 1, 0,1},
                {1, 1, 0,0},
                {0, 1, 1,1}
        };

        RatsMazeWhenMovementIsAllowedInAllDirections.findAPathWhenAllDirectionsAreAllowed(maze);
    }
*/

    public static void testNSlotsMOptionsInteger()
    {
        //using the case of generation of binary numbers
        Integer[] arr={0,1};
        List<Integer> options= Arrays.asList(arr);
        int numberOfSlots=3;
        SlotsAndOptions<Integer> slotsAndOptions=new SlotsAndOptions<Integer>();
        List<List<Integer>> allFillings=slotsAndOptions.generateAllPossibleFillings(numberOfSlots,options);

        for(List<Integer> filling: allFillings)
        {
            System.out.println(filling.toString());
        }

    }

}
