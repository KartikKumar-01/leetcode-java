class Solution 
{
    public int[][] outerTrees(int[][] t)
    {
        if(t.length<=3)
            return t;
        Arrays.sort(t,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });
        List<int[]> l=new ArrayList<>();
        List<int[]> u=new ArrayList<>();
        for(int[] ts:t)
        {
            while(l.size()>=2&&compare(l.get(l.size()-2),l.get(l.size()-1),ts)>0)
            {
                    l.remove(l.size()-1);
            }
            while(u.size()>=2&&compare(u.get(u.size()-2),u.get(u.size()-1),ts)<0)
            {
                    u.remove(u.size()-1);   
            }   
            l.add(ts);
            u.add(ts);
        }
        Set<int[]> set=new HashSet<>();
        for(int[] ls:l)
            set.add(ls);
        for(int[] us:u)
            set.add(us);
        int[][] res=new int[set.size()][2];
        int i=0;
        for(int[] s:set)
            res[i++]=s;   
        return res;
    }
    public int compare(int[] p1,int[] p2,int[] p3)
    {
        int x1=p1[0];
        int y1=p1[1];
        int x2=p2[0];
        int y2=p2[1];
        int x3=p3[0];
        int y3=p3[1];
        return(y3-y2)*(x2-x1)-(y2-y1)*(x3-x2);
    }
}