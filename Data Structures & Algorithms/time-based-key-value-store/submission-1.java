class TimeMap {

    class Value implements Comparable<Value>{
        public String val;
        public int timestamp;

        public Value(String val,int timestamp){
            this.val = val;
            this.timestamp = timestamp;
        }
        public int compareTo(Value that){
            return this.timestamp - that.timestamp;
        }
    }
    
    private Map<String,List<Value>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Value v = new Value(value,timestamp);
        if(hashMap.containsKey(key)){
            List<Value> list = hashMap.get(key);
            list.add(v);
        }else{
            List list = new ArrayList<>();
            list.add(v);
            hashMap.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)){
            return "";
        }
        List<Value> list = hashMap.get(key);
        int left = 0;
        int right = list.size()-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            int midTimeStamp = list.get(mid).timestamp;
            if(midTimeStamp <=timestamp){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(right < 0){
            return "";
        }
        return list.get(right).val;
    }
}
