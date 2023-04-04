class Solution {
    public int partitionString(String s) {
        int count = 0;
        
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        while(i < s.length()){            
            while(i < s.length() && !set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
            }
            count++;
            set.clear();
        }
        
        return count;
    }
}