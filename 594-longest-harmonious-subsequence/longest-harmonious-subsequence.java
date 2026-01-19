import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

       
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                int length = freq.get(key) + freq.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
