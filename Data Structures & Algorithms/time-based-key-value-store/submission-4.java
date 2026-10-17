class TimeMap {

    class Value{
        String val;
        int time;

        public Value(String val, int time){
            this.val = val;
            this.time = time;
        }
    }

    Map<String,List<Value>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Value val = new Value(value,timestamp);
        if(map.containsKey(key)){
            List<Value> currentList = map.get(key);
            currentList.add(val);
        }else{
            List<Value> newList = new ArrayList<>();
            newList.add(val);
            map.put(key,newList);
        }
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        List<Value> currentList = map.get(key);
        if(currentList == null || currentList.isEmpty()){
            return result;
        }
        int left = 0;
        int right = currentList.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(currentList.get(mid).time <=timestamp){
                result = currentList.get(mid).val;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }
}
