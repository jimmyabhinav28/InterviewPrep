package dev.anksandabhi.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The Knight's tour problem using backtracking is a NP complete problem.
 * The run time as observed depends on the size of the maze, and the order in which you try the moves from the cell
 * This program runs fine, but takes a lot of time for 8 x 8 maze
 * <p>
 * It is also to be noted that the knights tour may or may not have a solution always
 * When does it have a solution..
 * <p>
 * Read this article
 * http://www.math.cmu.edu/~nkomarov/21-110/knighttour.pdf
 * <p>
 * An m X n chessboard with m < n has a knight's tour unless one or more of these three conditions holds:
 * (a) m and n are both odd;
 * (b) m = 1, 2, or 4; or
 * (c) m = 3 and n = 4, 6, or 8
 * <p>
 * i have tried with a 5 * 4 matrix and a 3 * 10 matrix, they both work
 */
public class KnightsTour {

    public static void solveKnightsTour(int numberOfRows, int numberOfColumns) {
        int[][] maze = new int[numberOfRows][numberOfColumns];
        maze = initializeMazeWithNegative(maze);
        boolean toreturn = solveKnightsTour(maze, 0, 0, 0);
        if (toreturn) {
            printMaze(maze);
        } else {
            System.out.println("No solution");
        }

    }

    private static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] initializeMazeWithNegative(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++)
                maze[i][j] = -1;
        }
        return maze;
    }

    private static boolean solveKnightsTour(int[][] maze, int x, int y, int numberOfMoves) {
//        System.out.println("Checking for cordinates <" + x + "," + y + ">. " + "Number of moves is " + numberOfMoves );
//        printMaze(maze);

        if (isMoveToThisCellFeasible(maze, x, y)) {
            maze[x][y] = numberOfMoves;
//            System.out.println("Can place knight at <"+x+","+y+">. Maze as of now is \n");
//            printMaze(maze);
        } else {
//            System.out.println("Cannot place knight at <"+x+","+y+">  here. ");
            return false;
        }

        if (numberOfMoves == (maze.length * maze[0].length - 1)) {
            System.out.println("<X,Y>" + x + " " + y);
            return true;
        }


        List<KnightsMove> allKnightsMoves = getAllKnightMovesFromACell();

        for (int i = 0; i < allKnightsMoves.size(); i++) {
            int nextX = x + allKnightsMoves.get(i).moveInXDirection;
            int nextY = y + allKnightsMoves.get(i).moveInYDirection;
            if (solveKnightsTour(maze, nextX, nextY, numberOfMoves + 1))
                return true;
        }


        maze[x][y] = -1;
//        System.out.println("Cannot move knight from <"+x+","+y+">. Maze as of now is \n");
//        printMaze(maze);
        return false;
    }


    private static boolean isMoveToThisCellFeasible(int[][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == -1)
            return true;
        return false;


    }

    private static class KnightsMove {
        int moveInXDirection;
        int moveInYDirection;

        KnightsMove(int moveInXDirection, int moveInYDirection) {
            this.moveInXDirection = moveInXDirection;
            this.moveInYDirection = moveInYDirection;
        }
    }

    private static ArrayList<KnightsMove> getAllKnightMovesFromACell() {
        ArrayList<KnightsMove> allMoves = new ArrayList<>();
        KnightsMove move1 = new KnightsMove(1, 2);
        KnightsMove move2 = new KnightsMove(1, -2);
        KnightsMove move3 = new KnightsMove(-1, 2);
        KnightsMove move4 = new KnightsMove(-1, -2);

        KnightsMove move5 = new KnightsMove(2, 1);
        KnightsMove move6 = new KnightsMove(2, -1);
        KnightsMove move7 = new KnightsMove(-2, -1);
        KnightsMove move8 = new KnightsMove(-2, 1);

        allMoves.add(move1);
        allMoves.add(move2);
        allMoves.add(move3);
        allMoves.add(move4);
        allMoves.add(move5);
        allMoves.add(move6);
        allMoves.add(move7);
        allMoves.add(move8);

        return allMoves;
    }

}
