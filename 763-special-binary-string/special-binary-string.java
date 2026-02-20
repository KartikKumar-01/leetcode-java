class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        int sum = 0;
        int start = 0;

        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            sum += s.charAt(i) == '1' ? 1 : -1;

            if(sum == 0){
                String sbt = s.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(sbt) + "0");
                start = i + 1;
            }
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder res = new StringBuilder();
        for(String str : list){
            res.append(str);
        }
        return res.toString();
    }
}