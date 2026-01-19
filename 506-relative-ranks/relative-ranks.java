import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

       
        int[] sorted = score.clone();

       
        Arrays.sort(sorted);
        reverse(sorted);

       
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                map.put(sorted[i], "Gold Medal");
            } else if (i == 1) {
                map.put(sorted[i], "Silver Medal");
            } else if (i == 2) {
                map.put(sorted[i], "Bronze Medal");
            } else {
                map.put(sorted[i], String.valueOf(i + 1));
            }
        }

        
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(score[i]);
        }

        return result;
    }


    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
