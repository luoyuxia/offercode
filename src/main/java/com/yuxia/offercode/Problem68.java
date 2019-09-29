package com.yuxia.offercode;

public class Problem68 {
    public static void main(String[] args) {
        Problem68 problem68 = new Problem68();
        System.out.println(problem68.movingCount(18, 10, 10));
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        int[] res = new int[]{0};
        move(visited, rows, cols, 0, 0, threshold, res);
        return res[0];
    }

    public void move(boolean[][] visited, int rows, int cols, int i, int j, int threshold, int[] res) {
        if (i < 0 || j <0 || i >= rows || j >= cols)
            return;
        if (!visited[i][j] && reachable(i, j, threshold)) {
            visited[i][j] = true;
            res[0] += 1;
            move(visited, rows, cols, i - 1, j, threshold, res);
            move(visited, rows, cols, i + 1, j, threshold, res);
            move(visited, rows, cols, i, j - 1, threshold, res);
            move(visited, rows, cols, i, j + 1, threshold, res);
        }
    }

    private boolean reachable(int row, int col, int threshold) {
        int s = 0;
        while (row >= 10) {
            s += row % 10;
            row = row / 10;
        }
        s += row;
        while (col >= 10) {
            s += col % 10;
            col = col / 10;
        }
        s += col;
        return s <= threshold;
    }
}
