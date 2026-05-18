class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        // HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // for(int i = 0; i < n; i++){
        //     ArrayList<Integer> temp = new ArrayList<>();
        //     if(!map.containsKey(arr[i])){ 
        //         temp.add(i);
        //         for(int j = i + 1; j < n; j++) if(arr[j] == arr[i]) temp.add(j);
        //         map.put(arr[i], temp);
        //     }
        // }
        // System.out.println(map.toString());
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        // HashSet<String> set = new HashSet<>();
        // for(int key : map.keySet()){
        //     ArrayList<Integer> list = map.get(key);
        //     for(int i = 0; i < list.size(); i++){
        //         for(int j = 0; j < list.size(); j++){
        //             if(list.get(i) != list.get(j)){
        //                 String f = list.get(i) + " " + list.get(j);
        //                 String s = list.get(j) + " " + list.get(i);
        //                 if(!set.contains(f)){
        //                     adj.get(list.get(i)).add(list.get(j));
        //                     set.add(f);
        //                 }
        //                 if(!set.contains(s)){
        //                     adj.get(list.get(j)).add(list.get(i));
        //                     set.add(s);
        //                 }
        //             }
        //         }
        //     }
        // }
        // for(int i = 0; i < n; i++){
        //     String f = i + " " + (i + 1);
        //     String s = i + " " + (i - 1);
        //     if(!set.contains(f) && i + 1 < n){ 
        //         adj.get(i).add(i + 1);
        //         set.add(f);
        //     }
        //     if(!set.contains(s) && i - 1 >= 0) {
        //         adj.get(i).add(i - 1);
        //         set.add(s);
        //     }
        // }
        // for(ArrayList<Integer> temp : adj) System.out.println(temp.toString());

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int ans = 0;
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                if(cur == n - 1) return ans;
                
                if(cur - 1 >= 0 && !vis[cur - 1]){
                    q.offer(cur - 1);
                    vis[cur - 1] = true;
                }

                if(cur + 1 < n && !vis[cur + 1]){
                    q.offer(cur + 1);
                    vis[cur + 1] = true;
                }

                if(map.containsKey(arr[cur])){
                    for(int next : map.get(arr[cur])){
                        if(!vis[next]){
                            q.offer(next);
                            vis[next] = true;
                        }
                    }
                    map.remove(arr[cur]);
                }
            }
            ans++;
        }
        return ans;
    }
}