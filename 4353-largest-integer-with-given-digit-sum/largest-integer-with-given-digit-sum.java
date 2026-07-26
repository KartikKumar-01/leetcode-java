class Solution {
    public int largestInteger(int n, int s) {
        if(n * 9 < s) return -1;
        int ans = 0;
        while(s > 0){
            ans = ans * 10 + Math.min(9, s % (n * 10));
            s -= 9;
            n--;
        }
        while(n-- > 0) ans = ans * 10;
        return ans;
    }
}