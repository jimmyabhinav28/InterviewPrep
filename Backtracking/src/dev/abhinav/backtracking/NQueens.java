package dev.abhinav.backtracking;

public class NQueens {

    private static boolean isQueenSafeFromRightUpwardsDiagonal(Integer[][] maze, int row, int column) {
        int i=row-1;
        int j=column+1;
        while(i>=0 && j<maze.length) {
            if (maze[i--][j++] == 1) {
                System.out.println("Queen is not safe from right diagonal upwards");
                return false;
            }

        }
        return true;
    }


    private static boolean isQueenSafeFromRightDownwardDiagonal(Integer[][] maze, int row, int column) {
        int i=row+1;
        int j=column+1;
        while(i<maze.length && j<maze.length) {
            if (maze[i++][j++] == 1) {
                System.out.println("Queen is not safe from right diagonal downwards");
                return false;
            }

        }
        return true;
    }

    private static boolean isQueenSafeFromLeftUpwardsDiagonal(Integer[][] maze, int row, int column) {
        int i=row-1;
        int j=column-1;
        while(i>=0 && j>=0) {
            if (maze[i--][j--] == 1) {
                System.out.println("Queen is not safe from left diagonal upwards");
                return false;
            }

        }
        return true;
    }

    private static boolean isQueenSafeFromLeftDonwardsDiagonal(Integer[][] maze, int row, int column) {

        int i=row+1;
        int j=column-1;
            while(i<maze.length && j>=0) {
                if (maze[i++][j--] == 1) {
                    System.out.println("Queen is not safe from left diagonal downwards");
                    return false;
                }

        }
        return true;
    }

    private static boolean isQueenSafeDiagonally(Integer[][] maze, int row, int column) {
        return isQueenSafeFromRightUpwardsDiagonal(maze, row, column) &&
                isQueenSafeFromRightDownwardDiagonal(maze, row, column) &&
                isQueenSafeFromLeftUpwardsDiagonal(maze, row, column) &&
                isQueenSafeFromLeftDonwardsDiagonal(maze, row, column);
    }

    private static boolean isQueenSafeHorizontally(Integer[][] maze, int row) {
        for (int i = 0; i < maze.length; i++) {
            if (maze[row][i] == 1) {
                System.out.println("Queen is not safe horizontally");
                return false;
            }
        }
        return true;
    }

    private static boolean isQueenSafeVertically(Integer[][] maze, int column) {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][column] == 1) {
                System.out.println("Queen is not safe vertically");
                return false;
            }
        }
        return true;
    }

    private static boolean isQueenSafeInThisCell(Integer[][] maze, int row, int column) {
        return isQueenSafeDiagonally(maze, row, column) &&
                isQueenSafeHorizontally(maze, row) &&
                isQueenSafeVertically(maze, column);
    }

    public static boolean solveNQueens(Integer[][] maze, int numberOfQueensLeft) {

        System.out.println("Inside solve N queens. Number of queens left " + numberOfQueensLeft);
        if (numberOfQueensLeft == 0)
            return true;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.println("Considering row: " + i + " column: " + j);
                if (maze[i][j] == 1) {
                    System.out.println("already a queen sitting in  row: " + i + " column: " + j);
                    continue;

                }
                if (isQueenSafeInThisCell(maze, i, j)) {
                    System.out.println("Queen is safe in  row: " + i + " column: " + j);
                    maze[i][j] = 1;
                    if (solveNQueens(maze, numberOfQueensLeft - 1))
                        return true;
                } else {
                    //keep trying the next cell in order
                }
                //backtrack
                maze[i][j] = 0;
                System.out.println("Backtracking from  row: " + i + " column: " + j);
//                return false;
            }
        }

        return false;
    }
}
