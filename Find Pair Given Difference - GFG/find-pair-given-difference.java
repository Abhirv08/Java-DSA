// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int nums[], int size, int k)
    {
       Arrays.sort(nums);
       for(int i = 0; i < size; i++){
           if(bs(nums, k-nums[i], i) || bs(nums, k + nums[i], i))
            return true;
       }
       return false;
    }
    
    static boolean bs(int[] nums, int target, int idx){
        int s = 0;
        int e = nums.length-1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(mid != idx && nums[mid] == target){
                return true;
            }
            else if(nums[mid] > target){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return false;
    }
}