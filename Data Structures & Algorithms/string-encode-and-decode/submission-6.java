class Solution {

    public String encode(List<String> strs) {
        StringBuilder resultBuilder = new StringBuilder();
        for(String str : strs){
            resultBuilder.append(str.length());
            resultBuilder.append("#");
            resultBuilder.append(str);
        }
        
        return resultBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str==null){}
        int slow = 0;
        while(slow<str.length()){
            int fast = slow;
            while(str.charAt(fast)!='#'){
                fast++;
            }
            int length = Integer.parseInt(str.substring(slow,fast));
            String decoded = str.substring(fast+1,fast+length+1);
            result.add(decoded);
            slow = fast+length+1;
        }
        return result;
    }
}
