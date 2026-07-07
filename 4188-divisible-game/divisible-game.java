class Solution {
    public int divisibleGame(int[] nums) {
        int MOD = (int) 1e9 + 7;
        int n = nums.length;
        HashSet<Integer> factors = new HashSet<>();
        factors.add(2);
        for(int num : nums){
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0) {
                    factors.add(i);
                    while(num % i == 0) num /= i;
                }
            }
            if(num > 1) factors.add(num);
        }

        long maxD = Long.MIN_VALUE;
        int bestK = -1;
        for(int k : factors){
            long curd = Long.MIN_VALUE;
            long sum = 0;
            for(int num : nums){
                sum += (num % k == 0) ? num : -num;
                if(sum > curd) curd = sum;
                if(sum < 0) sum = 0;
            }
            if(curd > maxD){
                maxD = curd;
                bestK = k;
            }else if(curd == maxD){
                if(bestK == -1 || k < bestK){
                    bestK = k;
                }
            }
        }
        long ans = (maxD % MOD + MOD) % MOD;
        ans = (ans * (bestK % MOD)) % MOD;
        return (int)ans;
    }
}