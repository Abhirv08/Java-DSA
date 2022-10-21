//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
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
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        int[] ans = new int[R*C];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        putNumbers(a, 0, 0, R - 1, C - 1, list);
        
        int j = 0;
        for(int i = list.size() - 1; i >= 0; i--, j++){
            ans[j] = list.get(i);
        }
        
        return ans;
    }
    
    private void putNumbers(int[][] a, int top, int left, int down, int right, ArrayList<Integer> list){
        
        int dir = 0;
        
        while(top <= down && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    list.add(a[top][i]);
                }
                top++;
            }else if(dir == 1){
                for(int i = top; i <= down; i++){
                    list.add(a[i][right]);
                }
                right--;
            }else if(dir == 2){
                for(int i = right; i >= left; i--){
                    list.add(a[down][i]);
                }
                down--;
            }else{
                for(int i = down; i >= top; i--){
                    list.add(a[i][left]);
                }
                left++;
            }
            
            dir = (dir+1) % 4;
        }
        
    }
}