class Solution {    
    public static List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s: str){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            
            String key = String.valueOf(ch);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}