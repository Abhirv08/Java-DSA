//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int[] primes;
    
    static void getPrimes(){
        primes[0] = -1;
        primes[1] = -1;
        
        int i = 2;
        while(i <= primes.length){
            for(int j = 2*i; j < primes.length; j += i){
                primes[j] = -1;
            }
            
            i++;
            while(i < primes.length && primes[i] == -1){
                i++;
            }
        }
    }
    
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> list = new ArrayList<>();
        primes = new int[1000001];
        getPrimes();
        
        for(long num: query){
            int count = 0;
            for(int i = 0; i <= Math.sqrt(num); i++){
                if(primes[i] == 0) count++;
            }
            list.add(count);
        }
        
        return list;
    }
}