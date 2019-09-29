package com.yuxia.offercode;

public class Problem54 {
    public static void main(String[] args) {
        System.out.println(new Problem54().match(new char[]{'a', 'a', 'a'},
                new char[]{'a', 'b', '*', 'a', 'c', '*','a'}));
    }

    public boolean match(char[] str, char[] pattern)
    {
        if (str == null) {
            str = new char[]{};
        } else if (pattern == null){
            pattern = new char[]{};
        }
        return match(str, 0, pattern, 0);
    }


    private boolean match(char[] str, int i, char[] pattern, int j) {
        if (j == pattern.length) {
            return i == str.length;
        } else if (i == str.length) {
            return (j < pattern.length - 1) && pattern[j + 1] == '*' && match(str, i, pattern, j + 2);
        }
        boolean matched = pattern[j] == '.' || str[i] == pattern[j];

        return (matched && match(str, i + 1, pattern, j + 1)
                || (j < pattern.length - 1 && pattern[j + 1] == '*'
                && ((matched && match(str, i + 1, pattern, j) || match(str, i, pattern, j + 2)))));
    }
}
