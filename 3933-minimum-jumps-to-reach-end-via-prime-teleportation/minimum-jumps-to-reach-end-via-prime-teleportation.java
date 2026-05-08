class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashMap<Integer, List<Integer>> vals = new HashMap<>();
        for(int i = 0; i < n; i++){
            vals.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            max = Math.max(max, nums[i]);
        }
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 2; i * i <= max; i++){
            if(prime[i]){
                for(int j = i * i; j <= max; j+= i){
                    prime[j] = false;
                }
            }
        }
        for(int val : vals.keySet()) {

            int x = val;

            for(int p = 2; p * p <= x; p++) {

                if(x % p == 0) {

                    map.putIfAbsent(p, new ArrayList<>());
                    map.get(p).addAll(vals.get(val));

                    while(x % p == 0) x /= p;
                }
            }

            if(x > 1) {
                map.putIfAbsent(x, new ArrayList<>());
                map.get(x).addAll(vals.get(val));
            }
        }
        // System.out.println(map.toString());
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int jumps = 0;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int x = 0; x < size; x++){
                int idx = q.poll();
                if(idx == n - 1) return jumps;
                if(idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }
                if(idx + 1 < n && !vis[idx + 1]){ 
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }
                if(prime[nums[idx]] && map.containsKey(nums[idx]))
                    for(int i : map.get(nums[idx])){
                        if(!vis[i]) {
                            vis[i] = true;
                            q.offer(i);
                        }
                    }
                    map.remove(nums[idx]);
            }
            jumps++;
        }
        return -1;
    }
}