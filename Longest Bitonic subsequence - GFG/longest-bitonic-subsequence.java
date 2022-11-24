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
        int[] inc = new int[nums.length];
       
        for(int i = 0; i < nums.length; i++){
            inc[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j] && inc[j] + 1 > inc[i]){
                   inc[i] = 1 + inc[j];
                }
            }
        }
       
        int[] dec = new int[nums.length];
       
        for(int i = nums.length - 1; i >= 0; i--){
            dec[i] = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j] && dec[j] + 1 > dec[i]){
                    dec[i] = 1 + dec[j];
                }
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, inc[i] + dec[i] - 1);
        }
        
        return ans;
    }
}