package com.yuxia.offercode;

import java.util.HashMap;
import java.util.Map;

public class Problem56 {

    public static void main(String[] args) {
        Problem56 problem56 = new Problem56();
        problem56.Insert('g');
        System.out.println(problem56.FirstAppearingOnce());
        problem56.Insert('o');
        System.out.println(problem56.FirstAppearingOnce());
        problem56.Insert('o');
        System.out.println(problem56.FirstAppearingOnce());
        problem56.Insert('g');
        System.out.println(problem56.FirstAppearingOnce());
        problem56.Insert('l');
        System.out.println(problem56.FirstAppearingOnce());
        problem56.Insert('e');
        System.out.println(problem56.FirstAppearingOnce());
    }

    private StringBuilder stringBuilder = new StringBuilder();
    private Map<Character, Integer> characterIntegerMap = new HashMap<>();
    private int i = -1;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        characterIntegerMap.put(ch, characterIntegerMap.getOrDefault(ch, 0) + 1);
        stringBuilder.append(ch);
        if (i == -1) {
            i = 0;
        } else if (ch == stringBuilder.charAt(i)) {
            for (; i < stringBuilder.length();i++) {
                if (characterIntegerMap.get(stringBuilder.charAt(i)) == 1) {
                    break;
                }
            }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return (i == -1 || i == stringBuilder.length()) ? '#' : stringBuilder.charAt(i);
    }
}
