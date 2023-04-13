class Solution {
    public int maximumSwap(int num) {
        int n = Integer.toString(num).length();
        
        int[] nums = new int[n];
        int temp = num;
        int i = n-1;
        while(temp > 0){
            nums[i] = temp%10;
            i--;
            temp /= 10;
        }
        
        int[] max = new int[n];
        max[n-1] = n-1;
        for(i = n - 2; i >= 0; i--){
            if(nums[i] > nums[max[i+1]]){
                max[i] = i;
            }else{
                max[i] = max[i+1];
            }
        }
        //System.out.println(Arrays.toString(max));
        //System.out.println(Arrays.toString(min));
        
        for(i = 0; i < n; i++){
            if(nums[i] < nums[max[i]]){
                temp = nums[i];
                nums[i] = nums[max[i]];
                nums[max[i]] = temp;
                return toNumber(nums);
            }
        }
        
        return num;
    }
    
    private int toNumber(int[] nums){
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num*10 + nums[i];
        }
        
        return num;
    }
}