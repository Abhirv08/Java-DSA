class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        
        for(int i = 0, j = 0; i < s.length(); ){
            if(s.substring(i, i+1).equals(" ")){
                i++;
                j++;
            }else{
                while(i < s.length() && !s.substring(i, i+1).equals(" ")){
                    i++;
                }
                
                list.add(s.substring(j, i));
                j = i;
            } 
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = list.size() - 1; i > 0; i--){
            ans.append(list.get(i)).append(" ");
        }
        ans.append(list.get(0));
        
        return ans.toString();
    }
}