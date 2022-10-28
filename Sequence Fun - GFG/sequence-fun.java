//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    int mod = (int)(1e9+7);
    public int NthTerm(int n)
    {
        return helping(1L, 1, n)%mod;
    }
    
    private int helping(long num, int count, int n){
        if(count == n+1){
            return (int)num%mod;
        }
        num = ((num*count)%mod + 1)%mod;
        
        return helping(num, count+1, n)%mod;
    }
    
}