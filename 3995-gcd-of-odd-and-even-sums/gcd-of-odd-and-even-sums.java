class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumEven = n * (n + 1);
        int sumOdd = n * n;
        return gcd(sumEven, sumOdd);
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}