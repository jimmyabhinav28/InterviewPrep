package dev.abhinav.recursion;

public class SimplestRatInAMaze {
    /**
     * A Maze is given as N*N binary matrix of blocks where
     * source block is the upper left most block i.e., maze[0][0]
     * and destination block is lower rightmost block i.e., maze[N-1][N-1].
     * <p>
     * A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
     * In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path
     * from source to destination.
     * <p>
     * A valid path should be marked with all 2s. Find one valid path. The valid path(s) should be marked with 1s
     * <p>
     * Possible variations: Can the rat move multiple steps at once
     * What if the rat can move in all directions
     *
     * @param maze
     * @param row    row index of the cell from where the move is being considered
     * @param column column index of the cell from where the move is being considered.
     */
    public static boolean solveRatInMazeSinglePath(Integer[][] maze, int row, int column) {

//        System.out.println("Finding single path..checking for cell <" + row + "," + column + ">");
        if (row == maze.length - 1 && column == maze[0].length - 1) {
//            System.out.println("REACHED DESTINATION cell <" + row + "," + column + "> ");
            maze[row][column] = 2;
            return true;
        }
        if (row >= maze.length || column >= maze[0].length)
            return false; // the first return case was not matched, hence we are not in the last cell, and have overshot the maze limits
        if (maze[row][column] == 0) {
//            System.out.println("cell <" + row + "," + column + "> is not a part of a path");
            return false;
        }
        boolean moveToRightResultsInASolution = solveRatInMazeSinglePath(maze, row, column + 1);
        if (moveToRightResultsInASolution) {
            maze[row][column] = 2;
//            System.out.println("cell <" + row + "," + column + "> is  a part of a path");
            return true;
        }
        boolean moveDownwardsResultsInASolution = solveRatInMazeSinglePath(maze, row + 1, column);
        if (moveDownwardsResultsInASolution) {
            maze[row][column] = 2;
//            System.out.println("cell <" + row + "," + column + "> is  a part of a path");
            return true;
        }
//        System.out.println("cell <" + row + "," + column + "> is not a part of a path");
        maze[row][column] = 0;
        return false;

    }

    /**
     * A Maze is given as N*N binary matrix of blocks where
     * source block is the upper left most block i.e., maze[0][0]
     * and destination block is lower rightmost block i.e., maze[N-1][N-1].
     * <p>
     * A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
     * In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path
     * from source to destination.
     * <p>
     * A valid path should be marked with all 2s. Find ALL valid paths. The valid path(s) should be marked with 1s
     * <p>
     * Possible variations: Can the rat move multiple steps at once
     * What if the rat can move in all directions
     *
     * @param maze
     * @param row    row index of the cell from where the move is being considered
     * @param column column index of the cell from where the move is being considered.
     */
    public static boolean solveRatInMazeAllPaths(Integer[][] maze, int row, int column) {

//        System.out.println("Finding all paths..checking for cell <" + row + "," + column + ">");
        if (row == maze.length - 1 && column == maze[0].length - 1) {
//            System.out.println("REACHED DESTINATION cell <" + row + "," + column + "> ");
            maze[row][column] = 2;
            return true;
        }
        if (row >= maze.length || column >= maze[0].length)
            return false; // the first return case was not matched, hence we are not in the last cell, and have overshot the maze limits
        if (maze[row][column] == 0) {
//            System.out.println("cell <" + row + "," + column + "> is not a part of a path");
            return false;
        }
        boolean moveToRightResultsInASolution = solveRatInMazeAllPaths(maze, row, column + 1);
        boolean moveDownwardsResultsInASolution = solveRatInMazeAllPaths(maze, row + 1, column);

        if (moveDownwardsResultsInASolution || moveToRightResultsInASolution) {
            maze[row][column] = 2;
//            System.out.println("cell <" + row + "," + column + "> is  a part of a path");
            return true;
        }
//        System.out.println("cell <" + row + "," + column + "> is not a part of a path");
        maze[row][column] = 0;
        return false;

    }
}
