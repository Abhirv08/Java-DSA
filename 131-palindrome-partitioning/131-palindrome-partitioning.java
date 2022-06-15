class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generateAllCombs(s, 0, s.length(), new ArrayList<>(), ans);
        
        return  ans;
    }
    
    private void generateAllCombs(String s, int start, int end, List<String> list, List<List<String>> ans){
        if(start >= end){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                temp.add(list.get(i));
            }
            ans.add(temp);
            return;
        } 
        
        for(int i = start; i < end; i++){
            String leftpart = s.substring(start, i+1);
            if(isPalindrome(leftpart)){
                list.add(leftpart);
                generateAllCombs(s, i+1, end, list, ans);
                list.remove(list.size() - 1);
            }
        }
        
        return;
    }
    
    private boolean isPalindrome(String s){
        int i = 0; 
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            
            i++; 
            j--;
        }
        return true;
    }
}