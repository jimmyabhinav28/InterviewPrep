package dev.abhinav.recursion;

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

    public static List<Character> tryReachingLastCell(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            //reached last cell, success case
            return pathTillNow;
        }
        if (row > maze.length - 1 || column > maze[0].length - 1 || row < 0 || column < 0)
            return null;//maze limits overshot
        if (visited[row][column] == 1)
            return null;//do not consider this cell again as it was already visited
        if (maze[row][column] == 0)
            return null;
        visited[row][column] = 1;
        List<Character> pathFromRightMove = recurseForRightCell(maze, visited, row, column, pathTillNow);
        List<Character> pathFromLeftMove = recurseForLeftCell(maze, visited, row, column, pathTillNow);
        List<Character> pathFromDownwardMove = recurseForCellBelow(maze, visited, row, column, pathTillNow);
        List<Character> pathFromUpwardMove = recurseForCellAbove(maze, visited, row, column, pathTillNow);


        return null;
    }


    private static List<Character> recurseForRightCell(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        List<Character> rightPath = new ArrayList<Character>(pathTillNow);
        rightPath.add('R');
        List<Character> pathFromRightMove = tryReachingLastCell(maze, visited, row, column + 1, rightPath);
        if (pathFromRightMove.size() == rightPath.size()) //nothing else was added, no path down the line
        {
            return pathTillNow;
        }

        return pathFromRightMove;
    }

    private static List<Character> recurseForLeftCell(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        List<Character> rightPath = new ArrayList<Character>(pathTillNow);
        rightPath.add('L');
        List<Character> pathFromRightMove = tryReachingLastCell(maze, visited, row, column - 1, rightPath);
        if (pathFromRightMove.size() == rightPath.size()) //nothing else was added, no path down the line
        {
            return pathTillNow;
        }

        return pathFromRightMove;
    }

    private static List<Character> recurseForCellAbove(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        List<Character> rightPath = new ArrayList<Character>(pathTillNow);
        rightPath.add('U');
        List<Character> pathFromRightMove = tryReachingLastCell(maze, visited, row - 1, column, rightPath);
        if (pathFromRightMove.size() == rightPath.size()) //nothing else was added, no path down the line
        {
            return pathTillNow;
        }

        return pathFromRightMove;
    }

    private static List<Character> recurseForCellBelow(Integer[][] maze, Integer[][] visited, int row, int column, List<Character> pathTillNow) {
        List<Character> rightPath = new ArrayList<Character>(pathTillNow);
        rightPath.add('D');
        List<Character> pathFromRightMove = tryReachingLastCell(maze, visited, row + 1, column, rightPath);
        if (pathFromRightMove.size() == rightPath.size()) //nothing else was added, no path down the line
        {
            return pathTillNow;
        }

        return pathFromRightMove;
    }
}
