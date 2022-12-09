//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        int[][] dirs = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        long ans = 0;

        for(int cr = 0; cr < N; cr++){
            for(int cc = 0; cc < M; cc++){
                long count = 1L;
                for(int[] dir: dirs){
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];
                    
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                        count++;
                    }
                }
                ans += ((N*M)%1000000007 - count%1000000007)%1000000007;
            }
        }
        
        return ans%1000000007;
    }
}