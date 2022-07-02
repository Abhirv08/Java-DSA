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

        int[][] memo_arr = new int[uniques][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> e : memo.entrySet()){
            memo_arr[index][0] = e.getKey();
            memo_arr[index][1] = e.getValue();
            index++;
        }

        Arrays.sort(memo_arr, new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = memo_arr[i][0];
        }
        return ans;
    }
}