//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i < 10; i++){
            q.add(i);
        }
        
        int ans = 0;
        while(!q.isEmpty()){
            int num = q.remove();
            int lastDigit = num%10;
            if(num >= n && num <= m) ans++;
            
            if(lastDigit != 9){
                int formedNum = num*10 + lastDigit + 1;
                if(formedNum <= m){
                    q.add(formedNum);
                }
            }
            if(lastDigit != 0){
                int formedNum = num*10 + lastDigit - 1;
                if(formedNum <= m){
                    q.add(formedNum);
                }
            }
            
        }
        
        if(n == 0) ans++;
        return ans;
    }
}
