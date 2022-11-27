//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        int start = 0, end = 0;
        int sum = 0, subarraySum = 0;
        int acq = 0, rel = 0;
        
        for(;acq < n; acq++){
            if(a[acq] >= 0){
                subarraySum += a[acq];
            }else{
                if(subarraySum > sum){
                    sum = subarraySum;
                    start = rel;
                    end = acq - 1;
                }else if(subarraySum == sum){
                    if(end - start + 1 < acq - rel){
                        start = rel;
                        end = acq - 1;
                    }
                }
                rel = acq+1;
                subarraySum = 0;
            }
        }
        
        if(subarraySum >= 0){
            if(subarraySum > sum){
                sum = subarraySum;
                start = rel;
                end = acq - 1;
            }else if(subarraySum == sum){
                if(end - start + 1 < acq - rel){
                    start = rel;
                    end = acq - 1;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(; start <= end && a[start] >= 0; start++){
            ans.add(a[start]);
        }
        
        if(ans.size() == 0) ans.add(-1);
        
        return ans;
    }
}