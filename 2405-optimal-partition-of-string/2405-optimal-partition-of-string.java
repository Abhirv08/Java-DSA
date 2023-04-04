class Solution {
    public int partitionString(String s) {
        int count = 0;
        
        int i = 0;
        while(i < s.length()){
            HashSet<Character> set = new HashSet<>();
            
            while(i < s.length() && !set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
            }
            count++;
        }
        
        return count;
    }
}