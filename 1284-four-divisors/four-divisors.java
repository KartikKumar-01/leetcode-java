class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int x : nums){
            int sum = helper(x);
            // System.out.println(sum);
            if(sum != -1) ans += sum;
        }
        return ans;
    }
    private int helper(int x){
        int sum = 0;
        int count = 0;
        for(int i = 1; i * i <= x; i++){
            if(x % i == 0){
                sum += i;
                count++;
                if(i != x / i){
                    sum += (x / i);
                    count++;
                }
            }
        }
        return (count == 4) ? sum : -1;
    }
}