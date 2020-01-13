package dev.abhinav.utils;

public class MatrixUtils<T> {

    public  void print2DMatrix(T[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println(matrix[i][matrix[0].length - 1]);
        }
    }
}
