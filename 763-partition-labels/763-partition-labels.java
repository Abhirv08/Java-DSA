class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            lastIndex.put( s.charAt(i), i );
        }
        
        int start = 0;
        int end = lastIndex.get(s.charAt(start));
        int i = 0;
        while( i < s.length() ){
            int partsLength = end - start + 1;
            if( lastIndex.get(s.charAt(i)) > end ){
                end = lastIndex.get(s.charAt(i));
            }
            if( i == end){
                ans.add(partsLength);
                start = i + 1;
                if(i + 1 < s.length()) end = lastIndex.get(s.charAt(start));
            }
            
            i++;
        }
        
       return ans; 
    }
}