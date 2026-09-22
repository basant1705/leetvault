class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        int half = (m + n + 1) / 2;

        while (low <= high) {

            int i = low + (high - low) / 2;
            int j = half - i;

            int Aleft = (i == 0)
                    ? Integer.MIN_VALUE
                    : nums1[i - 1];

            int Aright = (i == m)
                    ? Integer.MAX_VALUE
                    : nums1[i];

            int Bleft = (j == 0)
                    ? Integer.MIN_VALUE
                    : nums2[j - 1];

            int Bright = (j == n)
                    ? Integer.MAX_VALUE
                    : nums2[j];
            if (Aleft <= Bright && Bleft <= Aright) {
                if ((m + n) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }
                double leftMax = Math.max(Aleft, Bleft);
                double rightMin = Math.min(Aright, Bright);

                return (leftMax + rightMin) / 2.0;
            }
            else if (Aleft > Bright) {
                high = i - 1;
            }
            else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}