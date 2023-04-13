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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        
        int[] left = new int[n];
        Arrays.fill(left, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        // System.out.println(Arrays.toString(left));
        
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                if(nums[j] < nums[i]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(right));
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, left[i] + right[i] - 1);
        }
        
        
        return ans;
    }
}