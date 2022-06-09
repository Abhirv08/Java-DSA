// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            long M = Long.parseLong(a[1]);
            long L = Long.parseLong(a[2]);
            long H[] = new long[N];
            long A[] = new long[N];
            for(int i = 0; i < N; i++){
                String a1[] = in.readLine().trim().split("\\s+");
                H[i] = Long.parseLong(a1[0]);
                A[i] = Long.parseLong(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.buzzTime(N, M, L, H, A));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static long buzzTime(int N, long M, long L, long H[], long A[]){
        // code here
        
        long start = 0;
        long end = 1000000000;
        while(start < end){
            long mid = start + (end - start)/2;
            long sum = 0;
            long speed = 0;
            for(int i = 0; i < N; i++){
                speed = H[i] + mid*A[i];
                if(speed >= L){
                    sum += speed;
                }
            }
            if(sum >= M){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
    
    static int find(long[] H, long[] A, int N){
        int index = 0;
        for(int i = 1; i < N; i++){
            if(A[index] > A[i]){
                index = i;
            }else if(A[index] == A[i]){
                if(H[index] > H[i]){
                    index = i;
                }
            }
        }
        return index;
    }
}
