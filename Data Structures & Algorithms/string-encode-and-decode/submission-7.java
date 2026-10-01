class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length());
            sb.append('#');
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int fast = 0;
        int slow = 0;
        while(fast<str.length()){
            if(str.charAt(fast) == '#'){
                int nextStringSize = Integer.parseInt(str.substring(slow,fast));//5
                String currentStr = str.substring(fast+1,fast+1+nextStringSize);
                result.add(currentStr);
                slow = fast+1+nextStringSize;
                //5#Hello5#World
                fast = fast+nextStringSize+1;
            }
            fast++;
        }
        return result;
    }
}
