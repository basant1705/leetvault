class Solution {
    public int maximumSwap(int num) {

        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

       
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }

        
        for (int i = 0; i < n; i++) {
            int current = digits[i] - '0';

           
            for (int d = 9; d > current; d--) {
                if (last[d] > i) {
                    
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;

                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
