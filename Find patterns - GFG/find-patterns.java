//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfSubsequences(String S, String W){
        int times = 0;

        char[] letters = S.toCharArray();

        while(true){
            int j = 0;
            for(int i = 0; i < letters.length; i++){
                if(letters[i] == W.charAt(j)){
                    letters[i] = '$';
                    j++;
                }

                if(j == W.length()){
                    times++;
                    break;
                }
            }
            if(j == W.length()){
                j = 0;
            }else{
                return times;
            }
        }
    }
}