class Solution {
    class Pair{
        String s;
        double val;
        public Pair(String s, double val){
            this.s = s;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> map = new HashMap<>();
        int n = equations.size();
        for(int i = 0; i < n; i++){
            List<String> list = equations.get(i);
            String u = list.get(0);
            String v = list.get(1);

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(new Pair(v, values[i]));
            map.get(v).add(new Pair(u, 1.0/ values[i]));
        }

        int q = queries.size();
        double[] res = new double[q];
        for(int i = 0; i < q; i++){
            List<String> query = queries.get(i);
            String u = query.get(0);
            String v = query.get(1);
            if(!map.containsKey(u) || !map.containsKey(v)){
                res[i] = -1.0;
                continue;
            } 

            double[] val = {-1};
            double[] product = {1};
            HashSet<String> vis = new HashSet<>();
            dfs(map, u, v, val, product, vis);
            res[i] = val[0];
        }
        return res;
    }

    public void dfs(HashMap<String, List<Pair>> map, String src, String dest, double[] val, double[] product, HashSet<String> vis){
        if(vis.contains(src)) return;
        vis.add(src);

        if(src.equals(dest)){
            val[0] = product[0];
            return;
        }
        for(Pair next : map.get(src)){
            String s = next.s;
            double v = next.val;
            product[0] *= v;
            dfs(map, s, dest, val, product, vis);
            product[0] /= v;
        }
    }
}