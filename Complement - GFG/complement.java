//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        int maxSum = 0;
        int sumSoFar = 0;
        
        int start = -1, end = -1;
        int st = 0;
        for(int i = 0; i < n; i++){
            sumSoFar += str.charAt(i) == '1' ? -1 : 1;
            
            if(sumSoFar < 0){
                sumSoFar = 0;
                st = i+1;
            }else if(sumSoFar > maxSum){
                maxSum = sumSoFar;
                start = st+1;
                end = i+1;
            }
        }
        
        Vector<Integer> ans = new Vector<>();
        ans.add(start);
        if(start >= 0){
            ans.add(end);
        }
        
        return ans;
    }
}