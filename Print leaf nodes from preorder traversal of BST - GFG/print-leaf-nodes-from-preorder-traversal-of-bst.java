//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int N)
    {
        if(N == 1) return arr;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int num: arr){
            int first = 0;
            int count = 0;
            while(!st.isEmpty() && num > st.peek()){
                if(first == 0) first = st.peek();
                st.pop(); 
                count++;
            }
            
            if(count >= 2){
                list.add(first);
            }
            
            st.push(num);
        }
        
        if(!st.isEmpty()) list.add(st.peek());
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}