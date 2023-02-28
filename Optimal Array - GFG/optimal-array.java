//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long[] ans = new long[n];
        ans[0] = 0;
        long[] sum = new long[n];
        sum[0] = a[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + a[i];
            long curr = 0;
            if(i%2 == 0){ // size = odd
                int j = i/2;
                curr += j*a[j] - sum[j-1];
                curr += (sum[i] - sum[j]) - a[j]*(i - j);
            }else{   // size = even
                int j = i/2;
                int mid = (a[j] + a[j+1])/2;
                curr += mid*(j+1) - sum[j];
                curr += (sum[i] - sum[j]) - mid*(i - j);
            }
            
            ans[i] = curr;
        }
        
        return ans;
    }
}
        
