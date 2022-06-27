// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            StringTokenizer stt = new StringTokenizer(br.readLine());
            long k1 = Long.parseLong(stt.nextToken());
            long k2 = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println( obj.sumBetweenTwoKth(a, n, k1, k2) );
            
        }
	}
}// } Driver Code Ends

class Solution { 
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        Arrays.sort(A);
        
        long ans = 0;
        
        boolean flag = false;
        for(int i = 0; i < (int)N; i++){

            if(flag){
                ans += A[i];
            }
            if((long)i == K1-1){
                flag = !flag;
            }
            
            if((long)i == K2-2){
                break;
            }

        }
        
        return ans;
    }
    
}
