package com.yuxia.offercode;

public class Problem67 {

    public static void main(String[] args) {
        char[] matrix = new char[]{'a', 'b', 'c', 'e','s', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = new char[]{'b','c','c','e','d'};
     //   str = new char[]{'a','b','c','b'};
        int rows = 3;
        int cols = 4;
        Problem67 problem67 = new Problem67();
        boolean res = problem67.hasPath(matrix, rows, cols, str);
        System.out.println(res);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[] visited = new boolean[matrix.length];
                if (hasPath(matrix, visited, rows, cols, i, j, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(char[] matrix, boolean[] visited, int rows, int cols, int i, int j, char[] str, int k) {
        if (k == str.length)
            return true;
        if (i < 0 || i >= rows)
            return false;
        if (j < 0 || j >= cols)
            return false;
        if (visited[i * cols + j])
            return false;
        if (matrix[i * cols + j] == str[k]) {
            visited[i * cols + j] = true;
            return hasPath(matrix, visited, rows, cols, i - 1, j, str, k + 1) ||
                    hasPath(matrix, visited, rows, cols, i + 1, j, str, k + 1)
                    || hasPath(matrix, visited, rows, cols, i, j - 1, str, k + 1)
                    || hasPath(matrix, visited, rows, cols, i, j + 1, str, k + 1);
        }
        return false;
    }
}
