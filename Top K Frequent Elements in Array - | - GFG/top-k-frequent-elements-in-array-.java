// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Pair implements Comparable<Pair>{
    int num;
    int occurance;

    Pair(int num, int occurance){
        this.num = num;
        this.occurance = occurance;
    }

    public int compareTo(Pair p){
        if(p.occurance == this.occurance){
            return p.num - this.num;
        }

        return p.occurance - this.occurance;
    }
}

class Solution {
    public int[] topK(int[] nums, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int uniques = 0;
        for(int num : nums){
            if(memo.containsKey(num)){
                memo.put(num, memo.get(num) + 1);
            }else{
                memo.put(num, 1);
                uniques++;
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> e : memo.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
        }


        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = pq.remove().num;
        }
        return ans;
    }
}