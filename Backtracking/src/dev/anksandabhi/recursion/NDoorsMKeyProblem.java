package dev.anksandabhi.recursion;

/**
 * Problem statement
 * Given an N * N binary maze where a 0 denotes that the position can be visited and a 1 denotes that the position
 * cannot be visited without a key, the task is to find whether it is possible to visit the bottom-right cell from
 * the top-left cell with AT MAX M keys along the way. If possible then print â€œYesâ€? else print â€œNoâ€?.
 */
public class NDoorsMKeyProblem {

    private static boolean reachLastCellWithMKeys(Integer[][] maze, int row, int column, int numberOfKeysLeft) {
        if (numberOfKeysLeft >= 0 && row == maze.length - 1 && column == maze[0].length - 1) {
            //you have reached the final cell with all or some keys left
            return true;
        }
        if (numberOfKeysLeft < 0 || row > maze.length - 1 || column > maze[0].length - 1) {
            //all keys exhausted or maze limits obliterated
            return false;
        }

        if (maze[row][column] == 1) { //1 is for cannot visit..be careful :)
            if (numberOfKeysLeft <= 0)
                return false;
            else
            {
                numberOfKeysLeft--;
                //continue processing
            }
        }

        boolean canReachLastCellMovingRight = reachLastCellWithMKeys(maze, row, column + 1,numberOfKeysLeft );
        boolean canReachLastCellMovingDown = reachLastCellWithMKeys(maze, row+1, column ,numberOfKeysLeft );

        if(canReachLastCellMovingDown || canReachLastCellMovingRight)
        {
            return true;
        }

        return false;
    }

    public static boolean canReachLastCellWithAtMaxMKeys(Integer[][]maze, int m)
    {
        return reachLastCellWithMKeys(maze,0,0,m);
    }
}
