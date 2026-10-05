class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< strs.size();i++){
            if(strs.get(i).equals("")){ sb.append(" "); }
            sb.append(strs.get(i));
            if(i<strs.size()-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if(str == ""){
            list.add("");
        }
        StringBuilder sb = new StringBuilder();
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
        if(sb.length() > 0){
            list.add(sb.toString());
        }
        return list;
    }
}
