package dev.abhinav.recursion;

import dev.abhinav.utils.MatrixUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider a rat placed at (0, 0) in a square matrix m[ ][ ] of order n and has to reach the destination at (n-1, n-1).
 * The task is to find a sorted array of strings denoting all the possible directions which the rat can take to reach
 * the destination at (n-1, n-1).
 * <p>
 * The directions in which the rat can move are ‘U'(up), ‘D'(down), ‘L’ (left), ‘R’ (right).
 */
public class RatsMazeWhenMovementIsAllowedInAllDirections {

    public static void findAPathWhenAllDirectionsAreAllowed(Integer[][] maze) {
        Integer[][] visited = new Integer[maze.length][maze[0].length];
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<>();
        matrixUtils.initialise2DIntegerMatrixWithZeros(visited);
        List<Character> pathTillNow=new ArrayList<>();
        tryReachingLastCell(maze, visited, 0, 0, pathTillNow);
        System.out.println("path is "+pathTillNow.toString());

    }

    public static void findAllPathsWhenAllDirectionsAreAllowed(Integer[][] maze) {
        Integer[][] visited = new Integer[maze.length][maze[0].length];
        MatrixUtils<Integer> matrixUtils = new MatrixUtils<>();
        matrixUtils.initialise2DIntegerMatrixWithZeros(visited);
        List<List<Character>> pathsTillNow=new ArrayList<>();
        tryReachingLastCell(maze, visited, 0, 0, pathTillNow);
        System.out.println("path is "+pathTillNow.toString());

    }

    public static boolean tryReachingLastCell(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {

//        System.out.println("checking  cell <"+row+" ,"+column+">");
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            //reached last cell, success case
//            System.out.println("reached destination cell");
            return true;
        }
        if (row > maze.length - 1 || column > maze[0].length - 1 || row < 0 || column < 0) {
//            System.out.println(" maze limits overshot, returning false");
            return false;//maze limits overshot
        }

        if (visited[row][column] == 1) {
//            System.out.println("already visited this cell");
            return false;//do not consider this cell again as it was already visited

        }

        if (maze[row][column] == 0) {
//            System.out.println("This cell cannot be traversed");
            return false;
        }
        visited[row][column] = 1;

        boolean pathFromRightMove = recurseForRightCell(maze, visited, row, column, pathTillNow);
        if (pathFromRightMove) {
//            System.out.println("move to right leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'R');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
            return true;
        }
        boolean pathFromLeftMove = recurseForLeftCell(maze, visited, row, column, pathTillNow);
        if (pathFromLeftMove) {
//            System.out.println("move to left leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'L');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
            return true;
        }
        boolean pathFromDownwardMove = recurseForCellBelow(maze, visited, row, column, pathTillNow);
        if (pathFromDownwardMove) {
//            System.out.println("move to downward direction leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'D');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
            return true;
        }
        boolean pathFromUpwardMove = recurseForCellAbove(maze, visited, row, column, pathTillNow);

        if (pathFromUpwardMove) {
//            System.out.println("move in upwards direction leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'U');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
            return true;
        }

//        System.out.println("No move worked from this cell");
        return false;
    }

    private static List<Character> addToPath(List<Character> pathTillNow, Character r) {
        if (pathTillNow == null)
            pathTillNow = new ArrayList<>();
//        System.out.println("adding character "+r+" to the path");
        pathTillNow.add(0, r);
        System.out.println("path till now is "+pathTillNow.toString());
        return pathTillNow;
    }

    private static List<Character> addToPathsList(List<List<Character>> pathTillNow, Character r) {
        if (pathTillNow == null)
            pathTillNow = new ArrayList<>();
//        System.out.println("adding character "+r+" to the path");
        pathTillNow.add(0, r);
        System.out.println("path till now is "+pathTillNow.toString());
        return pathTillNow;
    }


    private static boolean recurseForRightCell(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        boolean pathFromRightMove = tryReachingLastCell(maze, visited, row, column + 1, pathTillNow);
        return pathFromRightMove;
    }

    private static boolean recurseForLeftCell(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        boolean pathFromRightMove = tryReachingLastCell(maze, visited, row, column - 1, pathTillNow);
        return pathFromRightMove;
    }

    private static boolean recurseForCellAbove(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        boolean pathFromRightMove = tryReachingLastCell(maze, visited, row - 1, column, pathTillNow);
        return pathFromRightMove;
    }

    private static boolean recurseForCellBelow(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        boolean pathFromRightMove = tryReachingLastCell(maze, visited, row + 1, column, pathTillNow);
        return pathFromRightMove;
    }

    public static boolean dfsInMaze(Integer[][] maze, Integer[][] visited, int row, int column, List<List<Character>> pathTillNow) {

//        System.out.println("checking  cell <"+row+" ,"+column+">");
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            //reached last cell, success case
//            System.out.println("reached destination cell");
            return true;
        }
        if (row > maze.length - 1 || column > maze[0].length - 1 || row < 0 || column < 0) {
//            System.out.println(" maze limits overshot, returning false");
            return false;//maze limits overshot
        }

        if (visited[row][column] == 1) {
//            System.out.println("already visited this cell");
            return false;//do not consider this cell again as it was already visited

        }

        if (maze[row][column] == 0) {
//            System.out.println("This cell cannot be traversed");
            return false;
        }
        visited[row][column] = 1;

        boolean pathFromRightMove = recurseForRightCell(maze, visited, row, column, pathTillNow);
        if (pathFromRightMove) {
//            System.out.println("move to right leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'R');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
                return true;
        }
        boolean pathFromLeftMove = recurseForLeftCell(maze, visited, row, column, pathTillNow);
        if (pathFromLeftMove) {
//            System.out.println("move to left leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'L');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
                return true;
        }
        boolean pathFromDownwardMove = recurseForCellBelow(maze, visited, row, column, pathTillNow);
        if (pathFromDownwardMove) {
//            System.out.println("move to downward direction leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'D');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
                return true;
        }
        boolean pathFromUpwardMove = recurseForCellAbove(maze, visited, row, column, pathTillNow);

        if (pathFromUpwardMove) {
//            System.out.println("move in upwards direction leads to a solution");
            pathTillNow=addToPath(pathTillNow, 'U');
            if (pathTillNow != null)
//                System.out.println("Path till now \n" + pathTillNow.toString());
                return true;
        }

//        System.out.println("No move worked from this cell");
        return false;
    }

}
