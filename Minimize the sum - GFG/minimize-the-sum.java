//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    long minimizeSum(int N, int arr[]) {
        long sum = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num: arr){
            pq.add((long)num);
        }
        
        while(pq.size() > 1){
            long num1 = pq.poll();
            long num2 = pq.poll();
            
            sum += (num1 + num2);
            
            pq.add(num1+num2);
        }
        
        return sum;
    }
}

//{ Driver Code Starts.

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0; i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.minimizeSum(n, A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends