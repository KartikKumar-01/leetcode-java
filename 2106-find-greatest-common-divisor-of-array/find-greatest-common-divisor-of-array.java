class Solution {
    public int findGCD(int[] nums) {
        return gcd(Arrays.stream(nums).max().getAsInt(), Arrays.stream(nums).min().getAsInt());
    }
    private int gcd(int a, int b) {return b == 0 ? a : gcd(b, a % b);}
}