//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLaptops(int N, int[] start, int[] end) {
        int[][] period = new int[N][2];
        
        for(int i = 0; i < N; i++){
            period[i][0] = start[i];
            period[i][1] = end[i];
        }
        
        Arrays.sort(period, (a,b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]
            );
        
        int ans = 0;
        int time = period[0][0];
        for(int i = 0; i < N; ){
            while(i < N && period[i][0] == time){
                pq.add(period[i]);
                i++;
            }
            
            ans = Math.max(ans, pq.size());
            
            if(i < N) time = period[i][0];
            while(!pq.isEmpty() && pq.peek()[1] <= time){
                pq.poll();
            }
        }
        
        return ans;
    }
}