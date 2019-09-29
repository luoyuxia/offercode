package com.yuxia.offercode;

import java.util.HashMap;
import java.util.Map;

public class Problem9 {
    private Map<Integer, Integer> jumpMap = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        System.out.println(new Problem9().JumpFloor(2));
    }

    public int JumpFloor(int target) {
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        if (jumpMap.get(target - 1) == null) {
            jumpMap.put(target - 1, JumpFloor(target - 1));
        }
        if (jumpMap.get(target - 2) == null) {
            jumpMap.put(target - 2, JumpFloor(target - 2));
        }
        return jumpMap.get(target - 1) + jumpMap.get(target - 2);
    }
}
