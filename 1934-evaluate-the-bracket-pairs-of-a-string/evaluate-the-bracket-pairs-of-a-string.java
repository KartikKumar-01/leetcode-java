class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String, String> map = new HashMap<>();
        for(List<String> k : knowledge) map.put(k.get(0), k.get(1));

        int[] cb = new int[n];
        cb[n - 1] = s.charAt(n - 1) == ')' ? n - 1 : -1;
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == ')') cb[i] = i;
            else cb[i] = cb[i + 1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                int next = cb[i];
                String sbt = s.substring(i + 1, next);
                if(map.containsKey(sbt)){
                    sb.append(map.get(sbt));
                }else sb.append("?");
                i = next;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}