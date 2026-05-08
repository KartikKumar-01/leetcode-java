class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int word_len = words[0].length();
        int tot_len = word_len * (words.length);
        int word_count = words.length;

        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < word_len; i++){
            int left = i;
            int count = 0;
            HashMap<String, Integer> window = new HashMap<>();
            for(int right = left; right + word_len <= n; right += word_len){
                String sbtr = s.substring(right, right + word_len);
                if(map.containsKey(sbtr)){
                    window.put(sbtr, window.getOrDefault(sbtr, 0) + 1);
                    count++;
                    while(window.get(sbtr) > map.get(sbtr)){
                        String sub_left = s.substring(left, left + word_len);
                        window.put(sub_left, window.get(sub_left) - 1);
                        left += word_len;
                        count--;
                    }

                    if(count == word_count){
                        res.add(left);
                        String sub_left = s.substring(left, left + word_len);
                        window.put(sub_left, window.get(sub_left) - 1);
                        left += word_len;
                        count--;
                    }
                }else{
                    window.clear();
                    count = 0;
                    left = right + word_len;
                }
            }
        }
        return res;



        // for(int i = 0; i <= n - tot_len; i++){
        //     String sbtr = s.substring(i, i + word_len);
        //     // System.out.println("Sbtr: " + sbtr);
        //     if(map.containsKey(sbtr)){
        //         HashMap<String, Integer> window = new HashMap<>(map);
        //         // System.out.println("Sbtr: " + window.toString());
        //         window.put(sbtr, window.get(sbtr) - 1);
        //         // System.out.println("Sbtr: " + window.toString());
        //         int count = 1;
        //         for(int j = i + word_len; j < i + tot_len && j < n; j += word_len){
        //             String sbtr2 = s.substring(j, j + word_len);
        //             // System.out.println("Sbtr2: " + sbtr2);
        //             if(!window.containsKey(sbtr2) || window.get(sbtr2) == 0) break;
        //             count++;
        //             window.put(sbtr2, window.get(sbtr2) - 1);
        //             // System.out.println("Sbtr2: " + window.toString());
        //         }
        //         if(count == word_count) res.add(i);
        //     }
        // }
        // return res;
    }
    
}