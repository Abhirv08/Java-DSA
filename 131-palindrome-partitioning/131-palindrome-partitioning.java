class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        subStringGenerator(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void subStringGenerator(String s, int index, List<String> list, List<List<String>> ans){
        if(index == s.length()){            
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            String leftpart = s.substring(index, i+1);
            if(isPalindrome(leftpart)){
                list.add(leftpart);
                subStringGenerator(s, i+1, list, ans);
                list.remove(list.size() - 1);
            }
        }
        
        return;
    }
    
    private boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while( i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}