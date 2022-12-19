//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        List<List<int[]>> adj = buildTree(flights, n);
        
        int[] costs = new int[n+1];
        Arrays.fill(costs, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{k, 0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int src = node[0];
            int price = node[1];
            
            if(costs[src] != -1){
                continue;
            }
            
            costs[src] = price;
            for(int[] neigh: adj.get(src)){
                int ns = neigh[0];
                int p = price + neigh[1];
                
                pq.add(new int[]{ns, p});
            }
        }
        
        int ans = 0;
        for(int i = 1; i < n+1; i++){
            if(costs[i] == -1){
                return -1;
            }
            ans = Math.max(ans, costs[i]);
        }
        
        return ans;
    }
    
    private List<List<int[]>> buildTree(int[][] flights, int n){
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] flight: flights){
            int src = flight[0];
            int dest = flight[1];
            int price = flight[2];
            
            adj.get(src).add(new int[] {dest, price});
        }
        
        return adj;
    }
}
