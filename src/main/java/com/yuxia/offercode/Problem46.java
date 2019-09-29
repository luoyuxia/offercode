package com.yuxia.offercode;

public class Problem46 {
    public static void main(String[] args) {
        System.out.println(new Problem46().ReverseSentence("student. a am I"));
    }
    public String ReverseSentence(String str) {
        if (str == null || str.isEmpty()) return str;
        if (str.trim().equals("")) return str;
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
