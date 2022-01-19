class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
      List<Boolean> res = new ArrayList<>();
        for (String query: queries) {
            res.add(match(query, pattern));
        }
        return res;
    }
    
    private boolean match(String query, String pattern) {
        int i=0, j=0;
        while (i<query.length()&&j<pattern.length()) {
            if (query.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (Character.isUpperCase(query.charAt(i))) return false;
                i++;
            }
        }
        while (i<query.length()&&Character.isLowerCase(query.charAt(i))) i++;    
        return i==query.length()&&j==pattern.length();
    }
    
}