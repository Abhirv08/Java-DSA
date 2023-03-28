//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        

        while(t-->0){
            Shop shop = new Shop();

            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            long k = Long.parseLong(s[1]);

            s = br.readLine().trim().split(" ");

            for(String x: s){
                shop.addChocolate(Integer.parseInt(x));
            }
            
            ot.println(new Solution(shop).find(n, k));
        }
        ot.close();
    }
    
    
}
class Shop{
    private static List<Integer> chocoloates;
    private static int countOfCalls;
    Shop(){
        chocoloates = new ArrayList<>();
        countOfCalls = 0;
    }
    public static void addChocolate(int price){
        chocoloates.add(price);
    }

    public static int get(int i){
        countOfCalls++;
        if(countOfCalls > 50 || i >= chocoloates.size() || i < 0)
            return -1;
        return chocoloates.get(i);
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    
    static long find(int n, long k){
        long ans = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int minCost = shop.get(0);
        map.put(0, minCost);
        if(n == 1) return k/minCost;
        int r = n-1;
        while(k >= minCost){
            int l = 0;
            
            while(l < r){
                int m = l + (r-l)/2;
                
                int coins = 0;
                if(map.containsKey(m)){
                    coins = map.get(m);
                }else{
                    coins = shop.get(m);
                    map.put(m, coins);
                }
                
                if(coins == k){
                    r = m;
                    break;
                }else if(coins < k){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            
            int coins = 0;
            if(map.containsKey(r)){
                coins = map.get(r);
            }else{
                coins = shop.get(r);
                map.put(r, coins);
            }
            
            if(coins > k){
                if(r > 0){
                    if(map.containsKey(r-1)){
                        coins = map.get(r-1);
                    }else{
                        coins = shop.get(r-1);
                        map.put(r-1, coins);
                    }
                    r -= 2;
                }else return ans;
            }
            
            long chocolates =  (k/coins);
            ans += chocolates;
            k -= coins*(chocolates);
        }
        
        return ans;
    }

}