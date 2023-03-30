class Solution {
    Map<String, Boolean> mp=new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int n1=s1.length();
        if(s2.length()!=n1)
         return false;
        if(s1.equals(s2))
         return true;
        if(n1==1)
         return false;
        String key=s1+" "+s2;
        if(mp.containsKey(key))
         return mp.get((key));

         for(int i=1;i<n1;i++)
         {
             boolean with=(isScramble(s1.substring(0,i),s2.substring(0,i))&& isScramble(s1.substring(i),s2.substring(i)));

             if(with)
             {
                 mp.put(key,true);
                 return true;
             }

             boolean swap=(isScramble(s1.substring(0,i),s2.substring(n1-i))&& isScramble(s1.substring(i),s2.substring(0,n1-i)));

             if(swap)
             {
                 mp.put(key,true);
                 return true;
             }
         }
         mp.put(key,false);
         return false;
    }
}