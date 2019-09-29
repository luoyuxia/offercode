package com.yuxia.offercode;

public class Problem24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return sequence != null && sequence.length != 0 && VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (end - start <= 1)
            return true;
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end])
                break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end])
                return false;
        }
        return VerifySquenceOfBST(sequence, start, i - 1) || VerifySquenceOfBST(sequence, i, end - 1);
    }
}
