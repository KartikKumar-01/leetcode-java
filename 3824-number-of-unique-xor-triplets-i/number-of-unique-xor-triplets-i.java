class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <=2) return n;
        return (int) Math.pow(2, 32 - Integer.numberOfLeadingZeros(n));
    }
}