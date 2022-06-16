public class Solution {
    public int minDistance(String s1, String s2) {
        return minDistance(s1, 0, s2, 0, new HashMap<>());        
    }
    
    private int minDistance(String s1, int i1, String s2, int i2, HashMap<String, Integer> memo){
        if(i1 == s1.length() && i2 == s2.length()) return 0;
        if(i1 == s1.length() || i2 == s2.length()) return Math.max(s1.length() - i1, s2.length() - i2);
        String s = s1.substring(i1) + ":" + s2.substring(i2);
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        
        if(s1.charAt(i1) == s2.charAt(i2)){
            int d = minDistance(s1, i1+1, s2, i2+1, memo);
            memo.put(s, d);
            return d;
        }
            int removedFroms1 = minDistance(s1, i1+1, s2, i2, memo);
            int removedFroms2 = minDistance(s1, i1, s2, i2+1, memo);
            
            memo.put(s, Math.min(removedFroms1, removedFroms2) + 1);
        return Math.min(removedFroms1, removedFroms2) + 1;
    } 
}