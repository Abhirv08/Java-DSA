//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Arrays.sort(arr);
		    Complete obj = new Complete();
		    int ans = obj.maximizeSum(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        while(!map.isEmpty()){
            int largestNum = map.firstKey();

            sum += largestNum;

            map.put(largestNum, map.get(largestNum) - 1);
            if(map.get(largestNum) == 0){
                map.remove(largestNum);
            }

            if(map.containsKey(largestNum - 1)){
                map.put(largestNum - 1, map.get(largestNum - 1) - 1);
                if(map.get(largestNum - 1) == 0){
                    map.remove(largestNum - 1);
                }
            }
        }


        return sum;
    }
    
    
}


