class Solution {
    public int maxLength(List<String> arr) {
        List<String> ansList = new ArrayList<>();
        int ans = 0;
        
        ansList.add("");
        
        for(String s: arr){
            if(!containsUnique(s)) continue;
            List<String> newAnsList = new ArrayList<>();
            for(String str: ansList){
                String temp = str + s;
                if(containsUnique(temp)){
                    newAnsList.add(temp);
                    ans = Math.max(ans, temp.length());
                }
            }
            ansList.addAll(newAnsList);
        }
        
        return ans;
    }
    
    private boolean containsUnique(String s){
        HashSet<Character> set = new HashSet<>();

        for(char ch: s.toCharArray()){
            if(set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }

        return true;
    }
}