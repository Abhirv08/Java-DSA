class Solution {
    public int lengthOfLongestSubstring(String s) {
       if (s.length()==0) return 0;
        if(s.length() != 0 && s.trim().length() == 0) return 1;
        if(s.length() == 1 && s.trim().length() != 0) return 1;
        ArrayList<Character> containingItem = new ArrayList<>();
        int k = 0;
        int l = 0;
        containingItem.add(s.charAt(l));
        int r = 1;
        int max = 1;
        int counter = 1;
        boolean check = false;
        while(r < s.length()){
            if(!containingItem.contains(s.charAt(r))){
                containingItem.add(s.charAt(r));
                r++;
                counter++;
            }else{
                containingItem.remove(0);
                l++;
                check = true;
            }
            max = Math.max(max, r-l);
        }
        return max;
    }
   
}