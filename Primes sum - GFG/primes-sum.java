//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isSumOfTwo(int N){
        if(N < 4) return "No";
        int[] primes = primes(N);
        
        for(int i = 2; i <= N/2; i++){
            if(primes[i] != -1){
                int num2 = N - primes[i];
                if(primes[num2] != -1){
                    return "Yes";
                }
            }
        }
        
        return "No";
    }
    
    static int[] primes(int N){
        int[] prime = new int[N];
        
        for(int i = 0; i < N; i++){
            prime[i] = i;
        }
        
        prime[0] = -1;
        prime[1] = -1;
        
        int i = 2;
        while(i < Math.sqrt(N)){
            for(int j =i*2; j < N; j += i){
                prime[j] = -1;
            }
            i++;
        }
        
        return prime;
    }
    
}