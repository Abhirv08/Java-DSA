class Solution {
    public static int findMinArrowShots(int[][] x) {
        Arrays.sort(x, (a,b) -> a[0] - b[0] == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int ans = 1;
        int point = x[0][1];

        for(int i = 1; i < x.length; i++){
            if((x[i][1] < point)){
                point = x[i][1];
                continue;
            }else if(x[i][0] <= point) continue;
            else{
                ans++;
                point = x[i][1];
            }
        }

        return ans;
    }
}