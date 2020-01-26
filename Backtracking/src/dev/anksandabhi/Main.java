package dev.anksandabhi;

import dev.anksandabhi.backtracking.KnightsTour;
import dev.anksandabhi.backtracking.NQueens;
import dev.anksandabhi.backtracking.Sudoku2;
import dev.anksandabhi.recursion.*;
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
//        testNSlotsMOptionsInteger();
//        testPermuationsOfElementsWithGivenLength();
//        testCombinationsOfElementsWithGivenLength();
//        testSubsetGeneration();
//        testSubsetGenerationInteger();
//        testGetAllSubsetsOfGivenSum();
        testKnightsTour();
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
                {{1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1}};

        SimplestRatInAMaze.solveRatInMazeSinglePath(maze, 0, 0);
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<Integer>();
        matrixUtils.print2DMatrix(maze);

    }

    public static void testSimpleRatInAMazeAllPath() {
        Integer[][] maze =
                {{1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1}};

        SimplestRatInAMaze.solveRatInMazeAllPaths(maze, 0, 0);
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<Integer>();
        matrixUtils.print2DMatrix(maze);

    }

    public static void testNDoorsMKeys() {
        Integer[][] maze = {
                {0, 0, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 0}
        };

        boolean isFeasible = NDoorsMKeyProblem.canReachLastCellWithAtMaxMKeys(maze, 2);
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

    public static void testNSlotsMOptionsInteger() {
        //using the case of generation of binary numbers
        Integer[] arr = {0, 1};
        List<Integer> options = Arrays.asList(arr);
        int numberOfSlots = 3;
        SlotsAndOptions<Integer> slotsAndOptions = new SlotsAndOptions<Integer>();
        List<List<Integer>> allFillings = slotsAndOptions.generateAllPossibleFillings(numberOfSlots, options);

        for (List<Integer> filling : allFillings) {
            System.out.println(filling.toString());
        }

    }

    public static void testPermuationsOfElementsWithGivenLength() {
        Character[] allCharacters = {'a', 'b', 'c', 'd', 'e'};
        List<Character> elements = Arrays.asList(allCharacters);
        PermutationsAndCombinations<Character> characterPermutationsAndCombinations = new PermutationsAndCombinations<>();
        int lengthOfPermutation = 6;
        List<List<Character>> allPermutations = characterPermutationsAndCombinations.getAllPermutations(elements, lengthOfPermutation);
        System.out.println("number of permuations " + allPermutations.size() + "\n\n\n");
        for (List<Character> permutation : allPermutations) {
            System.out.println(permutation.toString());
        }
    }

    public static void testCombinationsOfElementsWithGivenLength() {
        Character[] allCharacters = {'a', 'b', 'c', 'd', 'e'};
        List<Character> elements = Arrays.asList(allCharacters);
        PermutationsAndCombinations<Character> characterPermutationsAndCombinations = new PermutationsAndCombinations<>();

        int lengthOfCombination = 3;
        List<List<Character>> allCombinations = characterPermutationsAndCombinations.allCombinationsOfGivenLength(elements, lengthOfCombination);

        System.out.println("number of combinations " + allCombinations.size() + "\n\n\n");
        for (List<Character> combination : allCombinations) {
            System.out.println(combination.toString());
        }
    }



    public static void testSubsetGeneration() {
        Character[] allCharacters = {'a', 'b', 'c'};
        List<Character> elements = Arrays.asList(allCharacters);
        SubsetsAndCombinations<Character> characterSubsetsAndCombinations = new SubsetsAndCombinations<>();
        List<List<Character>> allSubsets = characterSubsetsAndCombinations.getAllSubsets(elements);
        for (List<Character> subset : allSubsets) {
            System.out.println(subset.toString() + ",");
        }
    }

    public static void testSubsetGenerationInteger() {
        Integer[] allCharacters = {1,2,3,4};
        List<Integer> elements = Arrays.asList(allCharacters);
        SubsetsAndCombinations<Integer> characterSubsetsAndCombinations = new SubsetsAndCombinations<>();
        List<List<Integer>> allSubsets = characterSubsetsAndCombinations.getAllSubsets(elements);
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset.toString() + ",");
        }
    }

    public static void testGetAllSubsetsOfGivenSum() {
        Integer[] allCharacters = {1, 2, 3, 4, 5, 6};
        List<Integer> elements = Arrays.asList(allCharacters);

        List<List<Integer>> allSubsets = SubsetSum.allSubsetsThatAddUpToGivenSum(elements, 0);
        if (allSubsets != null) {
            for (List<Integer> subset : allSubsets) {
                System.out.println(subset.toString() + ",");
            }
        }
    }

    private static void testKnightsTour()
    {
        KnightsTour.solveKnightsTour(4,4);
    }
}
