class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> Integer.compare(map.get(y), map.get(x)));
        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : map.keySet()){
            pq.offer(c);
        }

        int key = 2;
        int round = 1;
        int ans = 0;
        while(!pq.isEmpty()){
            if(key > 9) {
                key = 2;
                round++;
            }
            ans += (round * map.get(pq.poll()));
            key++;
        }
        return ans;
    }
}