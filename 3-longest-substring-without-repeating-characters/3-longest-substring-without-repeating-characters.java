class Solution {
    public int lengthOfLongestSubstring(String s) {
        int acq = 0;
        int rel = 0;
        int largest = 0;
        int distn = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        while(acq < s.length()){
            String str = s.substring(acq, acq+1);
            if(memo.containsKey(str)){
                memo.remove(s.substring(rel, rel+1));
                rel++;
                distn--;
            }else{
                memo.put(str, acq);
                acq++;
                distn++;
            }
            largest = Math.max(largest, distn);
        }
        return largest;
    }   
}