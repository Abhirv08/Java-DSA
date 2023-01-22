class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        makePartitions(s, s.length(), 0, new ArrayList<>());
        return ans;
    }
    
    private void makePartitions(String s, int n, int idx, List<String> list){
        if(idx == n){
            ans.add(new ArrayList<>(list));
            return ;
        }
        
        for(int i = idx + 1; i < n+1; i++){
            String temp = s.substring(idx, i);
            if(isPalindrome(temp)){
                list.add(temp);
                makePartitions(s, n, i, list);
                list.remove(list.size() - 1);
            }
        }
        
        return ;
    }
    
    private boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        
        return true;
    }
}