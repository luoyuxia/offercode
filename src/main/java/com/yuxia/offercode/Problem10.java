package com.yuxia.offercode;

import java.util.HashMap;
import java.util.Map;

public class Problem10 {
    private Map<Integer, Integer> jumpMap = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        System.out.println(new Problem9().JumpFloor(2));
    }

    public int JumpFloorII(int target) {
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        int ans = 0;
        for (int i = 1; i <= target; i++) {
            if (jumpMap.get(target - i) == null) {
                jumpMap.put(target - i, JumpFloorII(target - i));
            }
            ans += jumpMap.get(target - i);
        }
        return ans;
    }
}
