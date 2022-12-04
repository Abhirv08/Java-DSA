class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] a = sentence.split(" ");
        
        
        int n = a.length;
        if(a[0].charAt(0) != a[n-1].charAt(a[n-1].length() - 1)) return false;
        
        for(int i = 0; i < n-1; i++){
            char lastChar = a[i].charAt(a[i].length() - 1);
            char firstChar = a[i+1].charAt(0);
            if(lastChar != firstChar) return false;
        }
        
        return true;
    }
}