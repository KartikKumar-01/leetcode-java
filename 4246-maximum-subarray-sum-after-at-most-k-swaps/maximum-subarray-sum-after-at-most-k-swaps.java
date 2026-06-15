class Solution {
    public long maxSum(int[] nums, int k) {
        int n = nums.length;

        int[] a = Arrays.copyOf(nums, n);
        Arrays.sort(a);
        long ans = Long.MIN_VALUE;
        TreeMap<Integer, Integer> candids = new TreeMap<>();
        TreeMap<Integer, Integer> others = new TreeMap<>();
        for(int i = 0; i < n; i++){
            long cur = 0;
            for(int j = n - k; j < n; j++){
                candids.put(a[j], candids.getOrDefault(a[j], 0) + 1);
            }
            for(int j = 0; j < n - k; j++){
                others.put(a[j], others.getOrDefault(a[j], 0) + 1);
            }

            for(int j = i; j < n; j++){
                if(!others.isEmpty()){
                    int key = others.containsKey(nums[j]) ? nums[j] : others.lastKey();
                    int val = others.get(key);
                    candids.put(key, candids.getOrDefault(key, 0) + 1);
                    if(val == 1) others.remove(key);
                    else others.put(key, val - 1);
                }
                int key = candids.lastKey();
                int val = candids.get(key);
                cur += key;
                if(val == 1) candids.remove(key);
                else candids.put(key, val - 1);

                ans = Math.max(ans, cur);
            }
            candids.clear();
            others.clear();
        }
        return ans;



        // boolean neg = false;

        // long sum = 0;
        // for(int x : nums) {
        //     if(x < 0) {
        //         neg = true;
        //         break;
        //     }
        //     sum += x;
        // }
        // if(!neg) return sum;
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
        // for(int x : nums) pq.offer(x);
        // PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
        // sum = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++){
        //     long cur = 0;
        //     int tk = k;
        //     long sumws = 0;
        //     PriorityQueue<Integer> min = new PriorityQueue<>();
        //     for(int j = i; j < n; j++){
        //         pq.remove(nums[j]);
        //         min.offer(nums[j]);
        //         sumws += (long) nums[j];
        //         cur = sumws;
        //         while(tk > 0 && !pq.isEmpty()){
        //             int mn = min.poll();
        //             int mx = pq.peek();
        //             if(mx <= mn) break;
        //             pq.poll();
        //             cur -= mn;
        //             cur += mx;
        //             sum = Math.max(sum, Math.max(cur, sumws));
        //             tk--;     
        //         }
        //         sum = Math.max(sum, Math.max(cur, sumws));
        //         tk = k;
        //     }
        //     pq = new PriorityQueue<>(temp);
        // }
        // return sum;
    }
}