package dev.abhinav.backtracking;

public class NQueens {

    private static boolean isQueenSafeFromRightUpwardsDiagonal(Integer[][] maze, int row, int column) {
        for (int i = row; i >= 0; i--) {
            for (int j = column; j < maze.length; j++) {
                if (maze[i][j] == 1)
                    return false;
            }
        }
        return true;
    }


    private static boolean isQueenSafeFromRightDownwardDiagonal(Integer[][] maze, int row, int column) {
        for (int i = row; i < maze.length; i++) {
            for (int j = column; j < maze.length; j++) {
                if (maze[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private static boolean isQueenSafeFromLeftUpwardsDiagonal(Integer[][] maze, int row, int column) {
        for (int i = row; i >= 0; i--) {
            for (int j = column; j >= 0; j--) {
                if (maze[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private static boolean isQueenSafeFromLeftDonwardsDiagonal(Integer[][] maze, int row, int column) {
        for (int i = row; i < maze.length; i++) {
            for (int j = column; j >= 0; j--) {
                if (maze[i][j] == 1)
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
            if (maze[row][i] == 1)
                return false;
        }
        return true;
    }

    private static boolean isQueenSafeVertically(Integer[][] maze, int column) {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][column] == 1)
                return false;
        }
        return true;
    }

    private static boolean isQueenSafeInThisCell(Integer[][] maze, int row, int column) {
        return isQueenSafeDiagonally(maze, row, column) &&
                isQueenSafeHorizontally(maze, row) &&
                isQueenSafeVertically(maze, column);
    }

    public static boolean solveNQueens(Integer[][] maze, int numberOfQueensLeft) {
        if (numberOfQueensLeft == 0)
            return true;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if(maze[i][j]==1)
                    continue;
                if (isQueenSafeInThisCell(maze, i, j)) {
                    maze[i][j] = 1;
                    if (solveNQueens(maze, numberOfQueensLeft - 1))
                        return true;
                } else {
                    //keep trying the next cell in order
                }
                //backtrack
                maze[i][j] = 0;
                return false;
            }
        }

        return false;
    }
}
