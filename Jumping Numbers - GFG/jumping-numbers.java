//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long jumpingNums(long X) {
        Queue<Long> q = new LinkedList<>();
        
        q.add(1L); q.add(2L); q.add(3L);
        q.add(4L); q.add(5L); q.add(6L);
        q.add(7L); q.add(8L); q.add(9L);
        
        long ans = 0;
        while(!q.isEmpty()){
            long num = q.poll();
            if(num <= X && num > ans){
                ans = num;
            }
            
            int rem = (int)num%10;
            if(rem == 0){
                long num1 = (long)(num*10 + 1L);
                if(num1 <= X){
                    q.add(num1);
                }
            }else if(rem == 9){
                long num1 = (long)(num*10 + 8L);
                if(num1 <= X){
                    q.add(num1);
                }
            }else{
                long num1 = (long)(num*10 + (rem + 1L));
                if(num1 <= X){
                    q.add(num1);
                }
                long num2 = (long)(num*10 + (rem - 1L));
                if(num2 <= X){
                    q.add(num2);
                }
            }
        }
        return ans;
    }
};