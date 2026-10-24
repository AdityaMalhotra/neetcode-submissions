class TimeMap {

    class TimeValue{
        String value;
        int timestamp;

        public TimeValue(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String,List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<TimeValue> list = map.get(key);
            list.add(new TimeValue(value,timestamp));
        }else{
            List<TimeValue> list = new ArrayList<>();
            list.add(new TimeValue(value,timestamp));
            map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(map.containsKey(key)){
            List<TimeValue> list = map.get(key);
            int left = 0;
            int right = list.size()-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(list.get(mid).timestamp <= timestamp){
                    result = list.get(mid).value;
                    left=mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return result;
    }
}
