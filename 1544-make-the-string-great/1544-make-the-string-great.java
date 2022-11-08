class Solution {
    public String makeGood(String s) {
        List<Character> list = new ArrayList<>();
        
        for(char ch: s.toCharArray()){
            list.add(ch);
        }
        
        int i = 0;
        while(i < list.size() - 1){
            char c1 = list.get(i);
            char c2 = list.get(i+1);
            if(Character.toLowerCase(c1) == Character.toLowerCase(c2)){
                if((Character.isLowerCase(c1) && Character.isUpperCase(c2)) || (Character.isLowerCase(c2) && Character.isUpperCase(c1)) ){
                    list.remove(i);
                    list.remove(i);
                    i = 0;
                    continue;
                }
            }
            
            i++;            
        }
        
        StringBuilder ans = new StringBuilder();
        for(char ch: list){
            ans.append(ch);
        }
        
        return ans.toString();
    }
}