class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int inf = Integer.MAX_VALUE / 2;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, inf);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = inf;
        for(int i = 0; i < n; i++){
            if(i > 0) dp[i] = dp[i - 1];
            sum += arr[i];
            if(map.containsKey(sum - target)){
                int j = map.get(sum - target);
                int len = i - j;
                if(j >= 0 && dp[j] != inf){
                    ans = Math.min(ans, len + dp[j]);
                }
                dp[i] = Math.min(dp[i], len);
            }
            map.put(sum, i);
        }
        return ans == inf ? -1 : ans;
    }
}