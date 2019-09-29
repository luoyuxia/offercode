package com.yuxia.offercode;

import java.util.ArrayList;

public class Problem20 {
    public static void main(String[] args) {
        System.out.println(new Problem20().printMatrix(new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
                {12, 13, 14},
                {15, 16, 17}
        }));
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (matrix == null || matrix[0] == null)
            return ans;
        printMatrix(ans, matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
        return ans;
    }

    private void printMatrix(ArrayList<Integer> ans,
                             int[][] matrix, int startRow, int startCol, int rows, int cols) {
        if (startRow > rows || startCol > cols)
            return;
        for (int i = startCol; i <= cols; i++) {
            ans.add(matrix[startRow][i]);
        }
        for (int i = startRow + 1; i <= rows; i++) {
            ans.add(matrix[i][cols]);
        }
        if (rows != startRow) {
            for (int i = cols - 1; i >= startCol; i--) {
                ans.add(matrix[rows][i]);
            }
        }
        if (cols != startCol) {
            for (int i = rows - 1; i > startRow; i --) {
                ans.add(matrix[i][startCol]);
            }
        }
        printMatrix(ans, matrix, startRow + 1, startCol + 1, rows - 1, cols -1);
    }
}
