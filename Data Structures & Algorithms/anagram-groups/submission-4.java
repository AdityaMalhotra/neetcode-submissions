class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0; i< strs.length;i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if(map.containsKey(sorted)){
                List<String> list = map.get(sorted);
                list.add(strs[i]);
            } else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted,list);
            }
        }
        for(String k : map.keySet()){
            result.add(map.get(k));
        }
        return result;
    }
}
