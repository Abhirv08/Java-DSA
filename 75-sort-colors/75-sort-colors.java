class Solution {
    public void sortColors(int[] nums) {
       //  int n = nums.length;
       // for(int i = 0; i< n-1; i++){
       //     for(int j = i+1; j> 0; j-- ){
       //         if(nums[j] < nums[j-1]){
       //             int temp = nums[j];
       //             nums[j] = nums[j-1];
       //             nums[j-1] = temp;
       //         }else{
       //             break;
       //         }
       //     }
       // }
        
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==2){
                int temp=nums[high];
                nums[high]=nums[mid];
                nums[mid]=temp;
                high--;
            }
            else{
                mid++;
            }
        }
    }
    
    
   
}