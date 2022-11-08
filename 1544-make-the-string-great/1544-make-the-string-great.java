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
            
            if(Math.abs(c1 - c2) == 32){
                list.remove(i);
                list.remove(i);
                i = 0;
                continue;
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