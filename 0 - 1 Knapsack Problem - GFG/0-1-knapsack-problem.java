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
    static int knapSack(int cap, int wt[], int val[], int n) 
    { 
    
         return maxValue(cap, wt, val, 0, new HashMap<String, Integer>() );
    } 
    
    static int maxValue(int w, int[] wt, int[] val, int i, HashMap<String, Integer> map){
        if(i == wt.length) return 0;
        
        String currentKey = Integer.toString(w) + "-" + Integer.toString(i);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int weightTaken = 0;
        if(w-wt[i] >= 0){
            weightTaken = val[i] + maxValue(w-wt[i], wt, val, i+1, map);
        }
        int weightNotTaken = maxValue(w, wt, val, i+1, map);
        
        map.put(currentKey,Math.max(weightTaken, weightNotTaken) );
        
        return Math.max(weightTaken, weightNotTaken);
    }
}


