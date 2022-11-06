//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1); set.add(2);set.add(5);set.add(10);
        set.add(20);set.add(50);set.add(100);set.add(200);
        set.add(500);set.add(2000);
        
        List<Integer> list = new ArrayList<>();
        
        while(N > 0){
            int value = set.floor(N);
            list.add(value);
            N -= value;
        }
        
        return list;
    }
    
    
}