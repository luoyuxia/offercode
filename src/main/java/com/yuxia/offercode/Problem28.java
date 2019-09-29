package com.yuxia.offercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem28 {
    public static void main(String[] args) {
        ArrayList<String> ans = new Problem28().Permutation("");
        System.out.println(ans);
    }
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.isEmpty())
            return new ArrayList<>();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
            characterList.add(str.charAt(i));
        ArrayList<String> ans = new ArrayList<>();
        Permutation(ans, new StringBuilder(), characterList, str.length());
        return ans;
    }

    private void Permutation(ArrayList<String> ans, StringBuilder stringBuilder, List<Character> characters,
                             int totalLen) {
        if (stringBuilder.length() == totalLen){
            ans.add(stringBuilder.toString());
            return;
        }
        Collections.sort(characters);
        for (int i = 0; i < characters.size(); i++) {
            if (i == 0 || characters.get(i-1) != characters.get(i)) {
                char ch = characters.get(i);
                stringBuilder.append(ch);
                characters.remove(i);
                Permutation(ans, stringBuilder, characters, totalLen);
                characters.add(i, ch);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
