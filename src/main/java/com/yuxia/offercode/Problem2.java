package com.yuxia.offercode;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(new Problem2().replaceSpace(new StringBuffer("hello world")));
    }
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ')
                stringBuilder.append(ch);
            else
                stringBuilder.append("%20");
        }
        return stringBuilder.toString();
    }
}
