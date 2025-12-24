import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
