class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< strs.size();i++){
            sb.append(strs.get(i));
            if(i<strs.size()-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(str == null){return list;}
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                String current = sb.toString();
                list.add(current);
                sb = new StringBuilder();
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        if(sb.length() >= 0){
            list.add(sb.toString());
        }
        return list;
    }
}
