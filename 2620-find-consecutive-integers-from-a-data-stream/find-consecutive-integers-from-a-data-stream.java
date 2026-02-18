class DataStream {
    int k;
    int last;
    int count;
    public DataStream(int value, int k) {
        this.k = k;
        this.last = value;
        count = 0;
    }
    
    public boolean consec(int num) {
        if(last == num){
            count++;
        }
        else{
            count = 0;
        }
        return count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */