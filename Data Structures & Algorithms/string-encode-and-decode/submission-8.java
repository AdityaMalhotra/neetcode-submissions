class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int slow =0;
        int fast = 0;
        while(slow < str.length()){
            while(str.charAt(fast)!='#'){fast++;}
            Integer size = Integer.parseInt(str.substring(slow,fast));
            String currentStr = str.substring(fast+1,fast+size+1);
            list.add(currentStr);
            slow = fast+size+1;
            fast = slow+1;
        }
        return list;
    }
}
