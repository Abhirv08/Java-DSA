class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int seconds = 0;

        while(s.contains("01")){
            StringBuilder str = new StringBuilder();
            int acq = 0, rel = 0;
            while (acq <= s.length()) {
                String temp = s.substring(rel, acq);
                if (temp.length() < 2) {
                    acq++;
                } else {
                    if (temp.equals("01")) {
                        str.append("10");
                        rel = acq;
                    } else {
                        str.append(s.substring(rel, rel + 1));
                        rel++;
                    }
                    acq++;
                }
            }
            if(acq == s.length() + 1 && rel == s.length() - 1) str.append(s.substring(rel, acq - 1));
            s = str.toString();
            seconds++;
        }
        

        return seconds;
    }
    
    
}