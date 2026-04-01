class Solution {
    class Object{
        int pos;
        int h;
        char dir;
        int idx;
        Object(int pos, int h, char dir, int i){
            this.pos = pos;
            this.h = h;
            this.dir = dir;
            this.idx = i;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Object[] a = new Object[n];
        for(int i = 0; i < n; i++){
            a[i] = new Object(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(a, (x, y) -> x.pos - y.pos);
        Stack<Object> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek().dir == 'R' && a[i].dir == 'L'){
                Object top = st.peek();
                if(top.h > a[i].h){
                    top.h -= 1;
                    a[i].h = 0;
                    break;
                }else if(top.h < a[i].h){
                    a[i].h -= 1;
                    st.pop();
                }else{
                    st.pop();
                    a[i].h = 0;
                    break;
                }
            }
            if(a[i].h > 0) st.push(a[i]);
        }
        List<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));

    while(!st.isEmpty()){
        Object cur = st.pop();
        res.set(cur.idx, cur.h);
    }

    List<Integer> ans = new ArrayList<>();
    for(int i = 0; i < n; i++){
        if(res.get(i) != -1){
            ans.add(res.get(i));
        }
    }

    return ans;
    }
}