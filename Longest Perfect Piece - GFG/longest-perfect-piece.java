//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int acq = 0, rel = 0;
        int ans = 0;
        int max = arr[acq];
        int min = arr[acq];
        
        
        while(acq < N){
            max = Math.max(arr[acq], max);
            min = Math.min(arr[acq], min);
            minHeap.add(arr[acq]);
            maxHeap.add(arr[acq]);
            if(max - min > 1){
                if(min == arr[acq]){
                    while(max - min > 1){
                        minHeap.remove(arr[rel]);
                        maxHeap.remove(arr[rel]);
                        max = Math.min(max, maxHeap.peek());
                        rel++;
                    }
                }else{
                    while(max - min > 1){
                        minHeap.remove(arr[rel]);
                        maxHeap.remove(arr[rel]);
                        min = Math.max(min, minHeap.peek());
                        rel++;
                    }
                }
            }
            ans = Math.max(ans, acq - rel + 1);
            acq++;
        }
        
        return ans;
    }
};