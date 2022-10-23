class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String[] e1s = event1[0].split(":");
        String[] e1e = event1[1].split(":");
        String[] e2s = event2[0].split(":");
        String[] e2e = event2[1].split(":");

        int s1 = giveTime(e1s);
        int e1 = giveTime(e1e);
        int s2 = giveTime(e2s);
        int e2 = giveTime(e2e);

        // if 2nd event starting before completion of 1st event
        if(e2 >= s1 && e1 >= s2){
            return true;
        }

        return false;
    }

    private int giveTime(String[] arr){
        int time = Integer.parseInt(arr[0])*60;
        time += Integer.parseInt(arr[1]);

        return time;
    }
    
}