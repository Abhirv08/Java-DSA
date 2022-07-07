// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int cap, int wt[], int val[], int n){ 
        
        return helping(cap, wt, val, n, new HashMap<>());
    }
    
    private static int helping(int cap, int[] wt, int[] val, int n, HashMap<String, Integer> memo ){
        if(n == 0 || cap == 0){
            return 0;
        }
        
        String currKey = n + ";" + cap;
        
        if(memo.containsKey(currKey)){
            return memo.get(currKey);
        }
        
        
        if(wt[n - 1] > cap){
            return helping(cap, wt, val, n - 1, memo);
        }
        
        int withConsidering = val[n - 1] + helping(cap - wt[n - 1], wt, val, n - 1, memo);
        int withoutConsidering = helping(cap, wt, val, n - 1,  memo);
        
        memo.put(currKey, Math.max(withConsidering, withoutConsidering));
        
        return Math.max(withConsidering, withoutConsidering);
    }

}


