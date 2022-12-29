//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<int[]> st = new Stack<>();
        
        for(int i = N - 1; i >= 0; i--){
            int currSize = Math.abs(asteroids[i]);
            int currDir = asteroids[i] > 0 ? 1 : -1;
            
            if(st.isEmpty()){
                st.push(new int[]{currSize, currDir});
            }else{
                if(currDir == -1 && st.peek()[1] == 1
                || currDir == st.peek()[1]){
                    st.push(new int[]{currSize, currDir});
                }else{
                    while(!st.isEmpty() && st.peek()[0] < currSize){
                        if(st.peek()[1] == currDir){
                            break;
                        }else{
                            st.pop();
                        }
                    }
                    
                    if(st.isEmpty() || st.peek()[1] == currDir){
                        st.push(new int[]{currSize, currDir});
                    }else if(st.peek()[0] == currSize){
                        st.pop();
                    }
                    
                    
                }
            }
        }
        
        int[] ans = new int[st.size()];
        int i = 0;
        while(!st.isEmpty()){
            ans[i] = st.peek()[0]*st.peek()[1];
            st.pop();
            i++;
        }
        
        return ans;
    }
}
