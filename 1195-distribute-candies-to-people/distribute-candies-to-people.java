class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int give = 1;
        int i = 0;
        while (candies > 0) {
            int idx = i % num_people;
            int used = Math.min(give, candies);
            res[idx] += used;
            candies -= used;
            give++;
            i++;
        }
        return res;
    }
}
