//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int arr[], int n){
        Deque<int[]> demand = new LinkedList<>();
        Deque<int[]> supply = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){
                supply.addLast(new int[]{-1*arr[i], i});
            }else if(arr[i] > 0){
                demand.addLast(new int[]{arr[i], i});
            }
        }
        
        long ans = 0;
        
        while(!demand.isEmpty() && !supply.isEmpty()){
            int[] need = demand.pollFirst();
            int wineNeeded = need[0];
            int needIndex = need[1];
            
            int[] available = supply.pollFirst();
            int wineAvailable = available[0];
            int availableIndex = available[1];
            
            if(wineNeeded == wineAvailable){
                ans += Math.abs(needIndex - availableIndex)*wineNeeded;
            }else if(wineNeeded > wineAvailable){
                ans += Math.abs(needIndex - availableIndex)*wineAvailable;
                demand.addFirst(new int[]{wineNeeded - wineAvailable, needIndex});
            }else{
                ans += Math.abs(needIndex - availableIndex)*wineNeeded;
                supply.addFirst(new int[]{wineAvailable - wineNeeded, availableIndex});
            }
        }
        
        return ans;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends