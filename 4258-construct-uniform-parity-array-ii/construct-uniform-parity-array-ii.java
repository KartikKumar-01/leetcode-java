class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int odd = 0;

        for (int num : nums1) {
            min = Math.min(min, num);
            if (num % 2 == 1) odd++;
        }

        return (min % 2 != 0) == (odd != 0);
    }
}