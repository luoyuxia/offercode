package com.yuxia.offercode;

import java.util.HashMap;
import java.util.Map;

public class Problem11 {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        System.out.println(new Problem11().RectCover(2));
    }
    public int RectCover(int target) {
        if (target <= 2)
            return target;
        if (map.get(target - 1) == null) {
            map.put(target - 1, RectCover(target - 1));
        }
        if (map.get(target - 2) == null) {
            map.put(target - 2, RectCover(target - 2));
        }
        return map.get(target - 1) + map.get(target - 2);
    }
}
