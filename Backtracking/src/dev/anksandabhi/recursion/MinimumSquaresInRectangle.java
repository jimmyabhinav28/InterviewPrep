package dev.anksandabhi.recursion;

public class MinimumSquaresInRectangle {

    /**
     * Find minimum number of sqaures that can be cut from a rectangle. The squares can be of different sizes
     * @param x
     * @param y
     * @return
     */
    public static int findMinimumNumberOfSquaresInRectangle(int x,int y)
    {
        if(x<=0 || y<=0)
        {
            System.out.println("Invalid input, both numbers should be positive");
            return -1;
        }
         int smallerNumber=x;
         int largerNumber=y;
         if(x>y) {
             smallerNumber = y;
             largerNumber=x;
         }

         if(largerNumber%smallerNumber==0)
             return (largerNumber/smallerNumber);

         int result=(int)(largerNumber/smallerNumber);
         int remainder=largerNumber%smallerNumber;
         result=result+findMinimumNumberOfSquaresInRectangle(remainder,smallerNumber);

         return result;
    }


}
