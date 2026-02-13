class Solution {
    public int longestBalanced(String s) {
        int n = s.length(), ans = 1, v1 = 0, v2 = 0;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        // Initialize with (0 → -1) to handle substrings starting from index 0 (balanced prefix)
        map.put(new Pair<>(0, 0), -1);

        // Case 1: Substring where counts of a, b, c are balanced
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a')
                v1++;
            else if (c == 'b')
                v2++;
            else {
                v1--;
                v2--;
            }
            Pair<Integer, Integer> p = new Pair<>(v1, v2);
            if (!map.containsKey(p))
                map.put(p, i);
            ans = Math.max(ans, i - map.get(p));
        }

        // Case 2: Balanced substrings for pairs ("ab", "bc", "ca")
        String[] comb = { "ab", "bc", "ca" };
        for (String c : comb) {
            char x = c.charAt(0), y = c.charAt(1);
            int v = 0;
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(0, -1);

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == x)
                    v++;
                else if (ch == y)
                    v--;
                else {
                    mp = new HashMap<>();
                    v = 0;
                }

                if (!mp.containsKey(v))
                    mp.put(v, i);
                ans = Math.max(ans, i - mp.get(v));
            }
        }

        // Case 3: Consecutive same character substrings
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else
                count = 1;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}