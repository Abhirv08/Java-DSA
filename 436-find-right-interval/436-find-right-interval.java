class Solution {
    public int[] findRightInterval(int[][] intervals) {
//         int n = intervals.length;
//         int[] ans = new int[n];
//         if(n==1){
//             ans[0] = -1;
//         }else{
//             ArrayList<Integer> arr = new ArrayList<>();
//             for(int i = 0; i< intervals.length; i++){
//                arr.add(intervals[i][0]); 
//             }
//             for(int i = 0; i< intervals.length; i++){
//                ans[i] = searchright(intervals, intervals[i][1], arr); 
//             }
//         }
//         return ans;
//     }
    
//     static int searchright(int[][] mat, int target, ArrayList<Integer> arr){
//         for(int i = 0; i < mat.length; i++){
//            if(arr.contains(target)){
//                if(mat[i][0] == target){
//                return i;
//              }
//            }else{
//                if(mat[i][0] > target){
//                return i;
//                  }
//            }
//         }
//         return -1;
//     }
    
     int[] first_elements=new int[intervals.length];
    for(int i=0;i<intervals.length;i++){
        first_elements[i]=intervals[i][0];
    }
    int[] result=new int[intervals.length];
    for(int i=0;i<intervals.length;i++){
        result[i]=right_interval(first_elements,intervals[i][1]);
    }
    return result;
}


public int right_interval(int[] arr,int target){
    int start=0;
    int end=arr.length-1;
	
   
	
    if(arr[start]<arr[end]){
        
     while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target)
            return mid;
        else if(target>arr[mid])
            start=mid+1;
        else 
            end=mid-1;
    }
        if(start>arr.length-1)
            return -1;
        else 
            return start;
    }
    else{
        while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target)
            return mid;
        else if(target>arr[mid])
            end=mid-1;
        else 
            start=mid+1;
    }
        if(end<0)
            return -1;
        else 
            return end;
        
    }
}
}