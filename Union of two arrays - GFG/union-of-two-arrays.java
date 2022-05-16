// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    
		    int n,m;
		    
		    //taking size of array a
		    n=sc.nextInt();
		    
		    //taking size of array b
		    m=sc.nextInt();
		    
		    //Creating 2 array of size n and m
		    int a[]=new int[n];
		    int b[]=new int[m];
		    
		    //inserting elements to array a
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    
		    //inserting elements to array b
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    Solution ob=new Solution();
		    //calling doUnion method and printing the results
		    System.out.println(ob.doUnion(a,n,b,m));
		}
		
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
       HashMap<Integer, Boolean> map1 = new HashMap<>();
       HashMap<Integer, Boolean> map2 = new HashMap<>();
       mapping(a, map1);
       mapping(b, map2);
       int count = 0;
       for(Map.Entry<Integer, Boolean> e: map1.entrySet()){
           if(map2.containsKey(e.getKey())){
               map2.remove(e.getKey());
           }
       } 
       return map1.size() + map2.size();
    }
    
    static void mapping(int[] nums, HashMap<Integer, Boolean> map){
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], true);
            }
        }
    }
}