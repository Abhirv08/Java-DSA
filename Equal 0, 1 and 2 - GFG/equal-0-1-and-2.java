// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        
       HashMap<String, Integer> memo = new HashMap<>();
        memo.put("0#0", 1);
        long subarrays = 0;
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.substring(i, i+1).equals("0"))
                zeros++;
            else if(str.substring(i, i+1).equals("1"))
                ones++;
            else
                twos++;

            String key = (ones - zeros) + "#" + (twos-ones);

            if(!memo.containsKey(key)){
                memo.put(key, 1);
            }else{
                subarrays += memo.get(key);
                memo.put(key, memo.get(key)+1);
            }

        }
        return subarrays;
    }
    
} 