// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        int start = 0;
        int end  = 0;
        while(end < n){
            if(!memo.containsKey(arr[end])){
                    memo.put(arr[end], 1);
            }else{
                memo.put(arr[end], memo.get(arr[end]) + 1);
            }
            if(end - start + 1 < k){
                end++;
            }else{
                ans.add(memo.size());
                end++;
                if(memo.get(arr[start]) <= 1){
                    memo.remove(arr[start]);
                }else{
                    memo.put(arr[start], memo.get(arr[start]) - 1);
                }
                start++;
            }
        }
        return ans;
    }
}

