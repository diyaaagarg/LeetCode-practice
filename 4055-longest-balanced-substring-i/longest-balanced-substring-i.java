import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if (allEqual(map)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private boolean allEqual(HashMap<Character, Integer> map) {
        int freq = -1;

        for (int value : map.values()) {
            if (freq == -1) {
                freq = value;
            } else if (freq != value) {
                return false;
            }
        }
        return true;
    }
}
