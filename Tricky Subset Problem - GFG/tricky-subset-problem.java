// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            long S = Long.parseLong(a[0]);
            int N = Integer.parseInt(a[1]);
            long X = Long.parseLong(a[2]);
            String a1[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            for(int i = 0;i < N;i++)
                A[i] = Long.parseLong(a1[i]);
            
            Solution ob = new Solution();
            if(ob.isPossible(S, N, X, A) == 1)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isPossible(long S, int N, long X, long A[])
    {
        ArrayList<Long> prefixSum = new ArrayList<>();
        prefixSum.add(S);
        
        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += prefixSum.get(i);
            prefixSum.add(sum + A[i]);
            if(sum >= X){
                break;
            }
        }
        
        int i = prefixSum.size() - 1;
        while(i >= 0 && X > 0){
            if(prefixSum.get(i) <= X){
                X -= prefixSum.get(i);
            }
            
            i--;
        }
        
        return X == 0 ? 1 : 0;
    }
    
}