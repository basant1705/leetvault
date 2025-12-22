class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;

       
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        for (int i = 0; i < n; i++) {
            boolean isUncommon = true;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }

            if (isUncommon) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
