//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch: w.toCharArray()){
            map.put(ch, (int)ch);
        }
        
        for(int i = 0; i < n; i++){
            map.put(x[i], b[i]);
        }
        
        int left = 0, right = 0;
        
        int currSum = 0;
        int maxSumTillNow = Integer.MIN_VALUE;
        
        String ans = "";
        while(right < w.length()){
            char ch = w.charAt(right);
            currSum += map.get(ch);
            
            if(currSum > maxSumTillNow){
                ans = w.substring(left, right + 1);
                maxSumTillNow = currSum;
            }
            
            if(currSum < 0){
                currSum = 0;
                left = right + 1;
            }
            
            right++;
        }
        
        return ans;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends