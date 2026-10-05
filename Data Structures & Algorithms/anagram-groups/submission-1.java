class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        List<String> currentList = null;
        for(int i = 0;i<strs.length;i++){
            if(!visited[i]){
                Map<Character,Integer> map = new HashMap<>();
                for(int j = 0;j<strs[i].length();j++){
                    Character currentChar = strs[i].charAt(j);
                    map.put(currentChar,map.getOrDefault(currentChar,0) + 1);
                }
                currentList = new ArrayList<>();
                currentList.add(strs[i]);
                for(int k=i+1;k<strs.length;k++){
                    Map<Character,Integer> currentMap = new HashMap<>();
                    for(int j = 0;j<strs[k].length();j++){
                        Character currentChar = strs[k].charAt(j);
                        currentMap.put(currentChar,currentMap.getOrDefault(currentChar,0) + 1);
                        if(!map.containsKey(currentChar)){
                            break;
                        }
                    }
                    if(currentMap.equals(map)){
                        visited[k] = true;
                        currentList.add(strs[k]);
                    }
                }
                if(currentList!=null && currentList.size()>0){
                    result.add(currentList);
                }
            }
        }
        return result;
    }
}
