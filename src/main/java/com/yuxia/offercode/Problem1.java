package com.yuxia.offercode;

public class Problem1 {
    public static void main() {

    }

    public boolean Find(int target, int [][] array) {
        return array != null && array.length != 0 && array[0].length != 0 && Find(target, array, 0, array.length - 1, array.length);
    }


    private boolean Find(int target, int [][] arr, int boundRow, int boundCol, int rows) {
        if (boundCol == 0) {
            for (int i = boundRow; i < rows; i++) {
                if (arr[i][0] == target)
                    return true;
            }
        } else if (boundRow == rows -1) {
            for (int i = boundCol; i >= 0; i--){
                if (arr[boundRow][i] == target)
                    return true;
            }
        } else {
            int v = arr[boundRow][boundCol];
            return v == target || ((target > v) && (Find(target, arr, boundRow + 1, boundCol, rows)))
                    || ((target < v) && Find(target, arr, boundRow, boundCol - 1, rows));
        }
        return false;
    }
}
