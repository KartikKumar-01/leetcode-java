class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
                List<Integer> temp = new ArrayList<>();
                int diff = a[i] - a[i - 1];
            if(diff < min){
                list.clear();
                temp.add(a[i - 1]);
                temp.add(a[i]);
                list.add(temp);
                min = diff;
            }
            else if(diff == min){
                temp.add(a[i - 1]);
                temp.add(a[i]);
                list.add(temp);
            }
        }
        return list;
    }
}