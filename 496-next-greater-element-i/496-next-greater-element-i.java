class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int pos = 0;
        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            int index = matchingIndex(num, nums2);
            if(index==nums2.length-1){
                ans[pos] = -1;
            }else{
                for(int j = index + 1; j < nums2.length; j++){
                    if(nums2[j] > num){
                        ans[pos] = nums2[j];
                        break;
                    }
                }
                if(ans[pos]==0){
                    ans[pos] = -1;
                }
            }
            pos++;
        }
        
        return ans;
    }
    
    static int matchingIndex(int num, int[] nums2){
        for(int i = 0; i < nums2.length; i++){
            if(num==nums2[i]){
                return i;
            }
        }
        return -1;
    }
    
}