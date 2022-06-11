// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            double a[] = new double[(int)(n)];
            double getAnswer[] = new double[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Double.parseDouble(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.nullPoints(n, a, getAnswer); 
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n-1;i++)
                output.append(String.format("%.2f", getAnswer[i])+" ");
                
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void nullPoints(int n, double magnet[], double getAnswer[])
   {
       // Your code goes here   
       for(int i=1;i<n;i++){
           double low = magnet[i-1],high = magnet[i];
           boolean fl = true;
           while(low<=high){
               double mid = low + (high-low)/2;
               double right_force = 0,left_force = 0;
               
               for(int j=i;j<n;j++){
                   left_force += (1/(magnet[j]-mid));
               }
               for(int j=i-1;j>=0;j--){
                   right_force += (1/(mid-magnet[j]));
               }
               
               if(Math.abs(right_force-left_force)<0.000001){
                   getAnswer[i-1] = mid;
                   fl = false;
                   break;
               }
               else if(right_force>left_force){
                   low = mid;
               }
               else{
                   high = mid;
               }
           }
           
           if(fl){
               getAnswer[i-1] = low;
           }
           
       }
       
   }
}


