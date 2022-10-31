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
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] satisfyEqn(int[] A, int N) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] ans = new int[4];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int sum = A[i] + A[j];
                if(!map.containsKey(sum)){
                    map.put(sum, new int[]{i, j});
                }else{
                    if(map.get(sum)[0] != i && map.get(sum)[1] != j && map.get(sum)[0] != j && map.get(sum)[1] != i){
                        int[] curr = new int[4];
                        curr[0] = map.get(sum)[0];
                        curr[1] = map.get(sum)[1];
                        curr[2] = i;
                        curr[3] = j;
                        if(ans[0] == Integer.MAX_VALUE){
                            ans[0] = curr[0];
                            ans[1] = curr[1];
                            ans[2] = curr[2];
                            ans[3] = curr[3];
                        }else{
                            boolean isFine = true;
                            for(int k = 0; k < 4; k++){
                                if(ans[k] > curr[k]){
                                    isFine = false;
                                    break;
                                }else if(ans[k] < curr[k]){
                                    break;
                                }
                            }
                            if(!isFine){
                                ans[0] = curr[0];
                                ans[1] = curr[1];
                                ans[2] = curr[2];
                                ans[3] = curr[3];
                            }
                        }
                    }
                }
            }
        }
        
        if(ans[0] == Integer.MAX_VALUE){
            Arrays.fill(ans, -1);
        }
        
        return ans;
    }
};