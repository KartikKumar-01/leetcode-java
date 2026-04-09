class Solution {
    final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int size = (int)Math.ceil(Math.sqrt(n));

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k >= size) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)(1L * nums[i] * v % MOD);
                }
            } else {
                map.putIfAbsent(k, new ArrayList<>());
                map.get(k).add(q);
            }
        }

        for (Map.Entry<Integer, ArrayList<int[]>> e : map.entrySet()) {

            int k = e.getKey();
            ArrayList<int[]> qs = e.getValue();

            int[] diff = new int[n];
            Arrays.fill(diff, 1);

            for (int[] q : qs) {
                int l = q[0], r = q[1], v = q[3];

                diff[l] = (int)(1L * diff[l] * v % MOD);

                int steps = (r - l) / k;
                int next = l + (steps + 1) * k;

                if (next < n) {
                    diff[next] = (int)(1L * diff[next] * power(v, MOD - 2) % MOD);
                }
            }

            for (int i = 0; i < n; i++) {
                if (i - k >= 0) {
                    diff[i] = (int)(1L * diff[i] * diff[i - k] % MOD);
                }
            }

            for (int i = 0; i < n; i++) {
                nums[i] = (int)(1L * nums[i] * diff[i] % MOD);
            }
        }

        int ans = 0;
        for (int x : nums) ans ^= x;

        return ans;
    }

    private int power(int a, int b) {
        long res = 1;
        long base = a;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            b >>= 1;
        }

        return (int)res;
    }
}