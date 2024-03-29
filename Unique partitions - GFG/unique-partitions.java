//{ Driver Code Starts
//Initial Template for Java

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
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        
        findPossibleWays(n, n - 1, arr, new ArrayList<>(), ans);
        return ans;
    }
    
    private void findPossibleWays(int n, int idx, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(idx < 0 || n < 0) return ;
        
        list.add(arr[idx]);
        if(n - arr[idx] == 0){
            ans.add(new ArrayList<>(list));
        }
        
        findPossibleWays(n - arr[idx], idx, arr, list, ans);
        list.remove(list.size() - 1);
        
        findPossibleWays(n, idx - 1, arr, list, ans);
        
        return;
    }
}